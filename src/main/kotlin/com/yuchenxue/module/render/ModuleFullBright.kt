package com.yuchenxue.module.render

import com.yuchenxue.event.events.PlayerTickEvent
import com.yuchenxue.event.handle
import com.yuchenxue.module.ClientModule
import com.yuchenxue.module.ModuleCategory
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects

/**
 * @author yuchenxue
 * @date 2025/01/15 - 14:16
 */

object ModuleFullBright : ClientModule(
    "FullBright",
    ModuleCategory.RENDER,
    "Feel lighting."
) {
    private val onUpdate = handle<PlayerTickEvent> {
        player.addStatusEffect(StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * (13 * 60 + 38)))
    }
}