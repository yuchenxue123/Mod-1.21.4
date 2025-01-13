package com.yuchenxue.module.render

import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import com.yuchenxue.ui.screen.ClickScreen
import com.yuchenxue.utils.client.ModuleInfo
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:24
 */

@ModuleInfo("ClickGUI", ModuleCategory.RENDER, "Display click screen", GLFW.GLFW_KEY_RIGHT_SHIFT)
object ModuleClickGui : ClientModule() {
    override fun enable() {
        mc.setScreen(ClickScreen)
        toggle()
    }
}