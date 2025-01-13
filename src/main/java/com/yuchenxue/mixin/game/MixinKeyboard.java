package com.yuchenxue.mixin.game;

import com.yuchenxue.event.EventManager;
import com.yuchenxue.event.events.KeyBoardEvent;
import com.yuchenxue.event.events.KeyEvent;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:51
 */

@Mixin(Keyboard.class)
public class MixinKeyboard {

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "onKey", at = @At(value = "FIELD",
            target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;",
            shift = At.Shift.BEFORE,
            ordinal = 0))
    private void hookKeyboardKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        var inputKey = InputUtil.fromKeyCode(key, scancode);

        EventManager.INSTANCE.callEvent(new KeyBoardEvent(inputKey, key, scancode, action));
        if (client.currentScreen != null) {
            EventManager.INSTANCE.callEvent(new KeyEvent(inputKey, action));
        }
    }
}
