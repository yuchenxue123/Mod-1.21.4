package com.yuchenxue.value.types.number.types

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.types.number.AbstractNumberValue

/**
 * @author yuchenxue
 * @date 2025/04/01
 */

class IntValue(
    name: String,
    default: Int = 0,
    range: IntRange = 0..20,
    override var step: Int = 1,
    displayCondition: DisplayCondition = { true }
) : AbstractNumberValue<Int>(name, default, displayCondition) {
    override val min = range.first
    override val max = range.last
    override val range = max - min
}