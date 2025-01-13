package com.yuchenxue.utils.client

import com.yuchenxue.module.ModuleCategory
import org.lwjgl.glfw.GLFW

/**
 * @author yuchenxue
 * @date 2025/01/12 - 20:10
 */

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ModuleInfo(
    val name: String,
    val category: ModuleCategory,
    val description: String = "",
    val key: Int = GLFW.GLFW_KEY_UNKNOWN
)