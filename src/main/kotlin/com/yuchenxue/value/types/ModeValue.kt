package com.yuchenxue.value.types

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.Value

/**
 * @author yuchenxue
 * @date 2025/04/01
 */

open class ModeValue(
    name: String,
    val modes: Array<String>,
    default: String,
    displayable: DisplayCondition
) : Value<String>(name, default, displayable) {
    override fun set(value: String) {
        val newMode = modes.find { it.equals(value, true) } ?: modes[0]
        super.set(newMode)
    }
}