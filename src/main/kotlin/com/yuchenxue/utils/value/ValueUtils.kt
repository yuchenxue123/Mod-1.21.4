package com.yuchenxue.utils.value

import com.yuchenxue.module.ClientModule

/**
 * @author yuchenxue
 * @date 2025/01/13 - 10:49
 */

val ClientModule.values: List<ValueData<*,*>>
    get() {
        val list = mutableListOf<ValueData<*,*>>()
        this::class.java.fields.forEach { field ->
            field.getAnnotation(BoolValue::class.java)?.let {
                list.add(BoolData(it, field))
            }
            field.getAnnotation(IntValue::class.java)?.let {
                list.add(IntData(it, field))
            }
            field.getAnnotation(FloatValue::class.java)?.let {
                list.add(FloatData(it, field))
            }
        }
        return list
    }