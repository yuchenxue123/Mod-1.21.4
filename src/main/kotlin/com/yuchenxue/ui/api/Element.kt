package com.yuchenxue.ui.api

import com.yuchenxue.utils.client.Accessor
import net.minecraft.client.gui.DrawContext

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:45
 */

interface Element : Accessor {
    fun render(context: DrawContext?, mouseX: Int, mouseY: Int, delta: Float)

    fun mouseClicked(mouseX: Double, mouseY: Double, button: Int){}

    fun mouseReleased(mouseX: Double, mouseY: Double, button: Int) {}

    fun keyPressed(keyCode: Int, scanCode: Int, modifiers: Int) {}
}