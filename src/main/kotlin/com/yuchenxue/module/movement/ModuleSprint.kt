package com.yuchenxue.module.movement

import com.yuchenxue.event.events.PlayerTickEvent
import com.yuchenxue.event.handle
import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import net.minecraft.client.MinecraftClient
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/12 - 20:24
 */

object ModuleSprint : ClientModule(
    "Sprint",
    ModuleCategory.MOVEMENT,
    "Auto sprint.",
    GLFW.GLFW_KEY_V
) {

    private val tick = handle<PlayerTickEvent> {
        val mc = MinecraftClient.getInstance()
        val player = mc.player ?: return@handle

//        if (allDirection) {
//            player.isSprinting = true
//            return@handle
//        }

        if (mc.options.forwardKey.isPressed
            && !player.isSneaking && player.input.movementInput.y > 0.8f
            && !player.horizontalCollision) {
            player.isSprinting = true
        }
    }
}