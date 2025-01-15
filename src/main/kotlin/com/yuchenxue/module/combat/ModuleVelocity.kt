package com.yuchenxue.module.combat

import com.yuchenxue.event.events.PacketReceiveEvent
import com.yuchenxue.event.handle
import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket

/**
 * @author yuchenxue
 * @date 2025/01/15 - 13:56
 */

object ModuleVelocity : ClientModule(
    "Velocity",
    ModuleCategory.COMBAT,
    "Anti knock back."
) {

    private val onPacketReceive = handle<PacketReceiveEvent> { event ->
        val packet = event.packet

        if (packet is EntityVelocityUpdateS2CPacket && packet.entityId == player.id) {
            event.cancelEvent()
        }
    }
}