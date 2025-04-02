package com.yuchenxue.ui.screen.clickgui

import com.yuchenxue.module.ModuleCategory
import com.yuchenxue.ui.api.ScreenElement
import com.yuchenxue.utils.extensions.fillRect
import net.minecraft.client.gui.DrawContext
import java.awt.Color

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:44
 */

class CategoryScreen : ScreenElement {

    private var category: ModuleCategory? = null

    companion object {
        fun create(): CategoryScreen {
            return CategoryScreen()
        }

        fun of(category: ModuleCategory): CategoryScreen {
            return create().setCategory(category)
        }
    }

    val moduleButtons = mutableListOf<ModuleButton>()

    var renderX: Int = 20
    var renderY: Int = 20

    val width = 120
    val height = fontHeight + 8

    private var open = false
    private var dragging = false

    // drag data
    private var dragX = 0
    private var dragY = 0

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {

        if (dragging) {
            renderX = mouseX - dragX
            renderY = mouseY - dragY
        }

        context.fillRect(renderX, renderY, width, height, Color(40,40,40,255).rgb)
        val text = category?.renderName ?: "NULL"
        context.drawTextWithShadow(
            font,
            text,
            renderX + (width - mc.textRenderer.getWidth(text)) / 2,
            renderY + (height - mc.textRenderer.fontHeight) / 2,
            Color.WHITE.rgb
        )
        if (open) {
            moduleButtons.forEach { it.render(context, mouseX, mouseY, delta) }
        }
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int) {
        val hovered = isHovered(renderX, renderY, width, height, mouseX, mouseY)
        if (hovered) {
            if (button == 0) {
                dragging = true
                dragX = mouseX.toInt() - renderX
                dragY = mouseY.toInt() - renderY
            }
            if (button == 1) {
                open = !open
            }
        }

        if (open) {
            moduleButtons.forEach { it.mouseClicked(mouseX, mouseY, button) }
        }
    }

    override fun mouseReleased(mouseX: Double, mouseY: Double, button: Int) {
        dragging = false

        if (open) {
            moduleButtons.forEach { it.mouseReleased(mouseX, mouseY, button) }
        }
    }

    fun refreshModuleElements() {
        var offset = height
        moduleButtons.forEach {
            it.offset = offset
            offset += height
        }
    }

    private fun buildModuleElements() {
        if (category == null) {
            return
        }

        moduleButtons.clear()
        category!!.modules.forEach { module ->
            moduleButtons.add(ModuleButton(module, this))
        }

        refreshModuleElements()
    }

    fun setCategory(category: ModuleCategory): CategoryScreen {
        this.category = category
        buildModuleElements()
        return this
    }

    fun setPosition(x: Int, y: Int): CategoryScreen {
        this.renderX = x
        this.renderY = y
        return this
    }
}