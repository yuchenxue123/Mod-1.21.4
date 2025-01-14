package com.yuchenxue.ui.api

import com.yuchenxue.utils.client.Accessor
import net.minecraft.client.font.TextRenderer

/**
 * @author yuchenxue
 * @date 2025/01/14 - 12:13
 */

interface FontAccessor : Accessor {
    val font: TextRenderer
        get() = mc.textRenderer

    val fontHeight: Int
        get() = font.fontHeight
}