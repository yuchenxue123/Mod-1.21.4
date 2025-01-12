package com.yuchenxue.module.movement

import com.yuchenxue.event.events.PlayerTickEvent
import com.yuchenxue.event.handle
import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import com.yuchenxue.utils.client.ModuleInfo
import net.minecraft.client.MinecraftClient

/**
 * @author yuchenxue
 * @date 2025/01/12 - 20:24
 */

@ModuleInfo("Sprint", ModuleCategory.MOVEMENT, "Auto sprint.")
object ModuleSprint : ClientModule() {

    init {
        this.state = true
    }

    private val tick = handle<PlayerTickEvent> {
        val mc = MinecraftClient.getInstance()
        val player = mc.player ?: return@handle
        if (mc.options.forwardKey.isPressed && !player.isSneaking && player.input.movementInput.y > 0.8f && !player.horizontalCollision) {
            player.isSprinting = true
        }
    }
}