package com.yuchenxue.module

/**
 * @author yuchenxue
 * @date 2025/01/12 - 19:10
 */

enum class ModuleCategory(val readableName: String) {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    RENDER("Render"),

    UNKNOWN("Unknown");
    ;

    fun getCategoryModules() = ModuleManager.modules.filter { it.category == this }.sortedBy { it.name }
}