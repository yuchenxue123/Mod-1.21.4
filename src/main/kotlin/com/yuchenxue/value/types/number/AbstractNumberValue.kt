package com.yuchenxue.value.types.number

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.Value


/**
 * @author yuchenxue
 * @date 2025/04/01
 */

abstract class AbstractNumberValue<T : Number>(
    name: String,
    value: T,
    displayCondition: DisplayCondition = { true }
) : Value<T>(name, value, displayCondition) {
    // min value
    abstract val min: T
    // max value
    abstract val max: T
    // range of value
    abstract val range: T
    // step when value change
    abstract val step: T
}