package com.yuchenxue.module.render

import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import com.yuchenxue.ui.screen.ClickScreen
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:24
 */

object ModuleClickGui : ClientModule(
    "ClickGUI",
    ModuleCategory.RENDER,
    "Display click screen",
    GLFW.GLFW_KEY_RIGHT_SHIFT,
    canEnable = false
) {
    override fun enable() {
        mc.setScreen(ClickScreen)
        toggle()
    }
}