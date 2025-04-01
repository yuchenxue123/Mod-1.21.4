package com.yuchenxue.value.special

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.choice.SubMode
import com.yuchenxue.value.types.ModeValue


/**
 * @author yuchenxue
 * @date 2025/04/01
 */

class EnumValue<E>(
    name: String,
    modes: Array<E>,
    default: E,
    displayCondition: DisplayCondition = { true }
) : ModeValue(
    name,
    modes.map { it.modeName }.toTypedArray(),
    default.modeName,
    displayCondition
) where E : Enum<E>, E : SubMode {
    var current = default
        private set

    init {
        onChange { _, new ->
            val newEnum = modes.find { it.modeName == new } ?: modes[0]
            current = newEnum
            return@onChange current.modeName
        }
    }
}