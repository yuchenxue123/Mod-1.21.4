package com.yuchenxue.utils.client

import com.yuchenxue.module.ModuleCategory

/**
 * @author yuchenxue
 * @date 2025/01/12 - 20:10
 */

@Target(AnnotationTarget.CLASS)
annotation class ModuleInfo(
    val name: String,
    val category: ModuleCategory,
    val description: String = ""
)