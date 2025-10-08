package com.nort8985.spidersense.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nort8985.spidersense.MonsterHighlighter;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "render", at = @At("TAIL"))
    void renderMonsterOverlay(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (client.player != null && client.interactionManager.getCurrentGameMode().isSurvivalLike() && MonsterHighlighter.closestMob != null) {
            String mobName = MonsterHighlighter.closestMob.getType().getName().getString();
            String text = mobName + " (" + String.format("%.0f", MonsterHighlighter.closestDistance) + "m)";

            TextRenderer textRenderer = client.textRenderer;
            int screenWidth = client.getWindow().getScaledWidth();
            int x = screenWidth / 2 - textRenderer.getWidth(text) / 2;
            int y = client.getWindow().getScaledHeight() - 50;

            context.fill(x - 2, y - 2, x + textRenderer.getWidth(text) + 2, y + textRenderer.fontHeight + 2, 0x80000000);
            context.drawText(textRenderer, text, x, y, 0xFFFF0000, false);
        }
    }
}
