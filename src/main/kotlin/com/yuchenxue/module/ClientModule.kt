package com.yuchenxue.module

import com.yuchenxue.event.Listenable
import com.yuchenxue.utils.client.Accessor
import com.yuchenxue.value.config.Configurable
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:09
 */

open class ClientModule(
    override val name: String,
    val category: ModuleCategory,
    val description: String = "None.",
    var key: Int = GLFW.GLFW_KEY_UNKNOWN,
    val canEnable: Boolean = true,
) : Configurable(name), Listenable, Accessor {

    var state = false
        set(value) {
            if (value == field) return
            field = value
            // Do something after toggle
            mc.inGameHud.chatHud.addMessage(Text.of("--$name ${if(value) "enable" else "disable"}"))
            if (value) enable() else disable()
        }

    open fun enable() {}
    open fun disable() {}

    fun toggle() {
        state = !state
    }

    override fun handleEvents(): Boolean = state
}