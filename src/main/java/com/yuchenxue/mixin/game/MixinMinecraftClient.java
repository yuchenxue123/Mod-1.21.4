package com.yuchenxue.mixin.game;

import com.yuchenxue.Client;
import com.yuchenxue.event.EventManager;
import com.yuchenxue.event.events.ClientShutdownEvent;
import com.yuchenxue.event.events.ClientStartEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:05
 */

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;onResolutionChanged()V"))
    private void startClient(CallbackInfo info) {
        EventManager.INSTANCE.callEvent(new ClientStartEvent());
        Client.INSTANCE.startClient();
    }

    @Inject(method = "stop", at = @At(value = "HEAD"))
    private void stopClient(CallbackInfo info) {
        EventManager.INSTANCE.callEvent(new ClientShutdownEvent());
    }
}
