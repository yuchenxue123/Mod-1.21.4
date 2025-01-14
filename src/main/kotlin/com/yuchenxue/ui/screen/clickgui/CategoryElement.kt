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

class CategoryElement : ScreenElement {

    var category: ModuleCategory? = null

    companion object {
        fun create(): CategoryElement {
            return CategoryElement()
        }

        fun of(category: ModuleCategory): CategoryElement {
            return create().setCategory(category)
        }
    }

    val moduleElements = mutableListOf<ModuleElement>()

    var renderX: Int = 20
    var renderY: Int = 20

    val width = 100
    val height = 18

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        if (context == null) return

        context.fillRect(renderX, renderY, width, height, Color(40,40,40,255).rgb)
        val text = category?.name ?: "NULL"
        context.drawTextWithShadow(
            mc.textRenderer,
            text,
            renderX + (width - mc.textRenderer.getWidth(text)) / 2,
            renderY + (height - mc.textRenderer.fontHeight) / 2,
            Color.WHITE.rgb
        )
        moduleElements.forEach { it.render(context, mouseX, mouseY, delta) }
    }

    fun refreshModuleElements() {
        var offset = height
        moduleElements.forEach {
            it.offset = offset
            offset += height
        }
    }

    private fun buildModuleElements() {
        if (category == null) {
            return
        }

        moduleElements.clear()
        category!!.getCategoryModules().forEach { module ->
            moduleElements.add(ModuleElement(module, this))
        }

        refreshModuleElements()
    }

    fun setCategory(category: ModuleCategory): CategoryElement {
        this.category = category
        buildModuleElements()
        return this
    }

    fun setPosition(x: Int, y: Int): CategoryElement {
        this.renderX = x
        this.renderY = y
        return this
    }
}