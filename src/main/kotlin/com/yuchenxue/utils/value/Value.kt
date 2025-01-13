package com.yuchenxue.utils.value

import java.lang.reflect.Field
import kotlin.reflect.KProperty

/**
 * @author yuchenxue
 * @date 2025/01/13 - 10:22
 */

@Target(AnnotationTarget.PROPERTY)
annotation class IntValue(
    val name: String,
    val min: Int = 0,
    val max: Int = 20
)

@Target(AnnotationTarget.PROPERTY)
annotation class FloatValue(
    val name: String,
    val min: Float = 0f,
    val max: Float = 20f
)

@Target(AnnotationTarget.FIELD)
annotation class BoolValue(
    val name: String
)

open class ValueData<T : Annotation, V>(val annotation: T, val field: Field) {
    fun set(value: V) {
        field.isAccessible = true
        field.set(field, value)
    }
}

class BoolData(annotation: BoolValue, field: Field) : ValueData<BoolValue, Boolean>(annotation, field) {
    val name get() = annotation.name
}
class FloatData(annotation: FloatValue, field: Field) : ValueData<FloatValue, Float>(annotation, field) {
    val name get() = annotation.name
    val min get() = annotation.min
    val max get() = annotation.max
}
class IntData(annotation: IntValue, field: Field) : ValueData<IntValue, Int>(annotation, field) {
    val name get() = annotation.name
    val min get() = annotation.min
    val max get() = annotation.max
}

open class RangeLimitProperty<T : Number>(
    val min: T,
    val max: T,
    var value: T
) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    open operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }
}

class FloatLimitProperty(
    min: Float,
    max: Float,
    value: Float
) : RangeLimitProperty<Float>(min, max, value) {
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
        this.value = value.coerceIn(min, max)
    }
}

class IntLimitProperty(
    min: Int,
    max: Int,
    value: Int
) : RangeLimitProperty<Int>(min, max, value) {
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.value = value.coerceIn(min, max)
    }
}