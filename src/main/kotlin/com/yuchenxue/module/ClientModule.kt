package com.yuchenxue.module

import com.yuchenxue.event.Listenable
import com.yuchenxue.utils.client.ModuleInfo

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:09
 */

open class ClientModule : Listenable {
    val name = this::class.java.getAnnotation(ModuleInfo::class.java)?.name ?: "UNKNOWN"
    val category = this::class.java.getAnnotation(ModuleInfo::class.java)?.category ?: ModuleCategory.UNKNOWN
    val description = this::class.java.getAnnotation(ModuleInfo::class.java)?.description ?: ""

    var state = false

    override fun handleEvents(): Boolean = state
}