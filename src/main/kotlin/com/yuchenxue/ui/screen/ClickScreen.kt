package com.yuchenxue.ui.screen

import com.yuchenxue.module.ModuleCategory
import com.yuchenxue.ui.api.FontAccessor
import com.yuchenxue.ui.screen.clickgui.CategoryElement
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text

/**
 * @author yuchenxue
 * @date 2025/01/13 - 11:08
 */

object ClickScreen : Screen(Text.empty()), FontAccessor {

    val categoryElements = mutableListOf<CategoryElement>()

    init {
        val y = 20
        var x = 10
        ModuleCategory.entries.forEach { category ->
            val element = CategoryElement.create().setCategory(category).setPosition(x, y)
            categoryElements.add(element)
            x += 2 + element.width
        }
    }

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(context, mouseX, mouseY, delta)

        categoryElements.forEach { it.render(context, mouseX, mouseY, delta) }
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int): Boolean {

        return super.mouseClicked(mouseX, mouseY, button)
    }

    override fun mouseReleased(mouseX: Double, mouseY: Double, button: Int): Boolean {

        return super.mouseReleased(mouseX, mouseY, button)
    }

    override fun keyPressed(keyCode: Int, scanCode: Int, modifiers: Int): Boolean {

        return super.keyPressed(keyCode, scanCode, modifiers)
    }

    override fun shouldPause(): Boolean {
        return false
    }
}