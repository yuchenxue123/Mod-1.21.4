package com.yuchenxue.command

import com.yuchenxue.command.client.BindCommand

/**
 * @author yuchenxue
 * @date 2025/01/13 - 14:34
 */

object CommandManager {
    val commands = mutableListOf<Command>()

    init {
        addCommand(
            BindCommand
        )
    }

    fun addCommand(vararg command: Command) {
        commands.addAll(command)
    }
}