package com.yuchenxue.utils.client

import net.minecraft.client.MinecraftClient
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.client.world.ClientWorld

/**
 * @author yuchenxue
 * @date 2025/01/12 - 20:10
 */

val mc: MinecraftClient
    get() = MinecraftClient.getInstance()
val player: ClientPlayerEntity
    get() = mc.player!!
val world: ClientWorld
    get() = mc.world!!