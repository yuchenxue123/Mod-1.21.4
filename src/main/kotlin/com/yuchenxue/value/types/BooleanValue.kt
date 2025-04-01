package com.yuchenxue.value.types

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.Value

/**
 * @author yuchenxue
 * @date 2025/04/01
 */

class BooleanValue(
    name: String,
    default: Boolean,
    displayable: DisplayCondition = { true }
) : Value<Boolean>(name, default, displayable)