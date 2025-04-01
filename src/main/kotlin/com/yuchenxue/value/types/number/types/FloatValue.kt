package com.yuchenxue.value.types.number.types

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.types.number.AbstractNumberValue


/**
 * @author yuchenxue
 * @date 2025/04/01
 */

class FloatValue(
    name: String,
    default: Float,
    range: ClosedFloatingPointRange<Float> = 0.1f..1f,
    override val step: Float = 0.1f,
    displayCondition: DisplayCondition = { true }
) : AbstractNumberValue<Float>(name, default, displayCondition) {
    override val min = range.start
    override val max = range.endInclusive
    override val range = max - min
}