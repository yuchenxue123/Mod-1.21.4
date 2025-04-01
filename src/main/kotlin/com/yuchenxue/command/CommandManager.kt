package com.yuchenxue.command

import com.yuchenxue.command.client.BindCommand

/**
 * @author yuchenxue
 * @date 2025/01/13 - 14:34
 */

object CommandManager {
    val commands = mutableListOf<Command>()

    init {
        val defaults = arrayOf(
            BindCommand
        )

        defaults.forEach(this::add)
    }

    private fun add(command: Command) {
        commands.add(command)
    }
}