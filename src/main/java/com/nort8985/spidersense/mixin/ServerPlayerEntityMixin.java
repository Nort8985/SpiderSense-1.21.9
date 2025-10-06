package com.nort8985.spidersense.mixin;

import com.nort8985.spidersense.MonsterHighlighter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.List;

@Environment(EnvType.SERVER)
@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends Entity {
    public ServerPlayerEntityMixin(EntityType<?> type, World world) { super(type, world); }

    @Inject(method = "tick", at = @At("HEAD"))
    void highlight(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        World world = player.getEntityWorld();
        if (world != null && player.getGameMode() == GameMode.SURVIVAL) {
            var pos = new Vec3d(player.getX(), player.getY(), player.getZ());
            var entities = world.getEntitiesByClass(MobEntity.class, new Box(pos.getX() - 8, pos.getY() - 5, pos.getZ() - 8, pos.getX() + 8, pos.getY() + 5, pos.getZ() + 8), e -> (e instanceof HostileEntity && ((HostileEntity) e).canSee(player)) || (e instanceof SlimeEntity && e.canSee(player)));
            for (MobEntity entity : entities) entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1200));
        }
    }
}
