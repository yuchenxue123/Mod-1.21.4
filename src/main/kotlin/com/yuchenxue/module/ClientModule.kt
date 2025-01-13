package com.yuchenxue.module

import com.yuchenxue.event.Listenable
import com.yuchenxue.utils.client.Accessor
import com.yuchenxue.utils.client.ModuleInfo
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:09
 */

open class ClientModule : Listenable, Accessor {
    val name = this::class.java.getAnnotation(ModuleInfo::class.java)?.name ?: "UNKNOWN"
    val category = this::class.java.getAnnotation(ModuleInfo::class.java)?.category ?: ModuleCategory.UNKNOWN
    val description = this::class.java.getAnnotation(ModuleInfo::class.java)?.description ?: ""
    var key = this::class.java.getAnnotation(ModuleInfo::class.java)?.key ?: GLFW.GLFW_KEY_UNKNOWN

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