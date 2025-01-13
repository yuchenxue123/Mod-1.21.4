package com.yuchenxue.ui.screen

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text
import java.awt.Color

/**
 * @author yuchenxue
 * @date 2025/01/13 - 11:08
 */

object ClickScreen : Screen(Text.empty()) {


    override fun render(context: DrawContext?, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(context, mouseX, mouseY, delta)
        if (context == null) return

        context.fill(50, 50, 360, 240, Color.WHITE.rgb)
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {

        return false
    }

    override fun shouldPause(): Boolean {
        return false
    }
}