package com.yuchenxue.value

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author yuchenxue
 * @date 2025/04/01
 */

typealias DisplayCondition = () -> Boolean
private typealias ChangeHandler<T> = (old: T, new: T) -> T

open class Value<T>(
    val name: String,
    private val default: T,
    displayable: DisplayCondition = { true }
) : ReadWriteProperty<Any?, T> {
    private var value: T = default

    // display conditions
    private val displayConditions = mutableListOf<DisplayCondition>()
        .apply { add(displayable) }

    // check value can display
    fun displayable(): Boolean = displayConditions.all { it.invoke() }

    // add display condition
    fun displayable(condition: DisplayCondition) {
        displayConditions.add(condition)
    }

    // get value
    fun get(): T {
        return value
    }

    // change handlers
    private val changeHandlers = mutableListOf<ChangeHandler<T>>()

    // set value
    open fun set(newValue: T) {

        changeHandlers.forEach { it.invoke(value, newValue) }

        this.value = newValue
    }

    // add change handler
    fun onChange(handler: ChangeHandler<T>) = apply {
        changeHandlers.add(handler)
    }

    // reset to default value
    fun reset() {
        value = default
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return get()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        set(value)
    }
}