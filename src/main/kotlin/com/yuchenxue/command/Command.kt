package com.yuchenxue.command

/**
 * @author yuchenxue
 * @date 2025/01/13 - 14:33
 */

abstract class Command(vararg names: String) {
    abstract fun execute(args: List<String>)
}