package com.yuchenxue.module

import com.yuchenxue.event.Listenable
import com.yuchenxue.event.events.KeyBoardEvent
import com.yuchenxue.event.handle
import com.yuchenxue.module.combat.ModuleVelocity
import com.yuchenxue.module.movement.ModuleSprint
import com.yuchenxue.module.render.ModuleClickGui
import com.yuchenxue.module.render.ModuleFullBright
import com.yuchenxue.utils.client.Accessor
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:10
 */

object ModuleManager : Listenable, Accessor {

    val modules = mutableListOf<ClientModule>()

    init {
        registerModule(
            // combat
            ModuleVelocity,
            // move
            ModuleSprint,
            // render
            ModuleClickGui,
            ModuleFullBright
        )
    }

    private val onKey = handle<KeyBoardEvent> { event ->
        when (event.action) {
            GLFW.GLFW_PRESS -> {
                if (mc.currentScreen == null) {
                    modules.filter { it.key == event.keyCode && event.key.category == InputUtil.Type.KEYSYM }
                        .forEach { module -> module.state = !module.state }
                }
            }
        }
    }

    private fun registerModule(vararg module: ClientModule) {
        modules.addAll(module)
    }
}