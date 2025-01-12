package com.yuchenxue.module

import com.yuchenxue.event.Listenable
import com.yuchenxue.module.movement.ModuleSprint

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:10
 */

object ModuleManager : Listenable {

    val modules = mutableListOf<ClientModule>()

    init {
        registerModule(
            ModuleSprint
        )
    }

    private fun registerModule(vararg module: ClientModule) {
        modules.addAll(module)
    }
}