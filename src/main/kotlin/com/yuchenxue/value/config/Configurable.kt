package com.yuchenxue.value.config

import com.yuchenxue.value.DisplayCondition
import com.yuchenxue.value.Value
import com.yuchenxue.value.choice.SubMode
import com.yuchenxue.value.special.EnumValue
import com.yuchenxue.value.types.BooleanValue
import com.yuchenxue.value.types.ModeValue
import com.yuchenxue.value.types.number.types.FloatValue
import com.yuchenxue.value.types.number.types.IntValue

/**
 * @author yuchenxue
 * @date 2025/04/01
 */

open class Configurable(
    open val name: String
) {
    val values = mutableListOf<Value<*>>()

    protected fun boolean(
        name: String,
        value: Boolean,
        displayCondition: DisplayCondition = { true }
    ) : BooleanValue = BooleanValue(name, value, displayCondition).also {
        values.add(it)
    }

    protected fun float(
        name: String,
        value: Float,
        range: ClosedFloatingPointRange<Float> = 0.1f..1f,
        step: Float = 0.1f,
        displayable: DisplayCondition = { true }
    ) : FloatValue = FloatValue(name, value, range, step, displayable).also {
        values.add(it)
    }

    protected fun int(
        name: String,
        value: Int,
        range: IntRange = 0..20,
        step: Int = 1,
        displayCondition: DisplayCondition = { true }
    ) : IntValue = IntValue(name, value, range, step, displayCondition).also {
        values.add(it)
    }

    protected fun mode(
        name: String,
        modes: Array<String>,
        value: String = modes[0],
        displayCondition: DisplayCondition = { true }
    ) : ModeValue = ModeValue(name, modes, value, displayCondition).also {
        values.add(it)
    }

    protected fun <E> enum(
        name: String,
        array: Array<E>,
        displayable: DisplayCondition = { true }
    ) where E : Enum<E>, E : SubMode = EnumValue(name, array, array[0], displayable).also {
        values.add(it)
    }

    protected inline fun <reified E> enum(
        name: String,
        value: E,
        noinline displayable: DisplayCondition = { true }
    ) where E : Enum<E>, E : SubMode = EnumValue(name, enumValues<E>(), value, displayable).also {
        values.add(it)
    }
}