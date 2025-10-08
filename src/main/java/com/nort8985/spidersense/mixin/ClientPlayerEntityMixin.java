package com.nort8985.spidersense.mixin;

import com.nort8985.spidersense.MonsterHighlighter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Shadow public MinecraftClient client;

    @Inject(method = "tick", at = @At("HEAD"))
    void highlight(CallbackInfo ci) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        if (MonsterHighlighter.duration <= 0) {
            MonsterHighlighter.list = new ArrayList<>();
            MonsterHighlighter.duration = -1;
            MonsterHighlighter.closestMob = null;
            MonsterHighlighter.closestDistance = Double.MAX_VALUE;
        } else MonsterHighlighter.duration--;

        World world = client.world;
        if (world != null && client.interactionManager.getCurrentGameMode() == GameMode.SURVIVAL) {
            var pos = new Vec3d(player.getX(), player.getY(), player.getZ());
            List<MobEntity> entities = world.getEntitiesByClass(MobEntity.class, new Box(pos.getX() - 16, pos.getY() - 8, pos.getZ() - 16, pos.getX() + 16, pos.getY() + 8, pos.getZ() + 16), e -> (e instanceof HostileEntity && ((HostileEntity) e).canSee(player)) || (e instanceof SlimeEntity && e.canSee(player)));
            if (!entities.isEmpty()) {
                MonsterHighlighter.duration = 20;
                MonsterHighlighter.list = entities;

                // Find closest mob
                MobEntity closest = null;
                double minDist = Double.MAX_VALUE;
                for (MobEntity ent : entities) {
                    double dist = pos.distanceTo(new Vec3d(ent.getX(), ent.getY(), ent.getZ()));
                    if (dist < minDist) {
                        minDist = dist;
                        closest = ent;
                    }
                }
                MonsterHighlighter.closestMob = closest;
                MonsterHighlighter.closestDistance = minDist;
            }
        }
    }
}
