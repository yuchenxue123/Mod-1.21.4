package com.yuchenxue.ui.api

import net.minecraft.client.gui.DrawContext

/**
 * @author yuchenxue
 * @date 2025/01/14 - 12:04
 */

interface DrawableElement : FontAccessor {
    fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float)
}