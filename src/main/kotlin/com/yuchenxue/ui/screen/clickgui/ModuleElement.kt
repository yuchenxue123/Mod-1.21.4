package com.yuchenxue.ui.screen.clickgui

import com.yuchenxue.module.ClientModule
import com.yuchenxue.ui.api.Element
import com.yuchenxue.utils.extensions.fillRect
import net.minecraft.client.gui.DrawContext
import java.awt.Color

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:52
 */

class ModuleElement(
    val module: ClientModule,
    val parent: CategoryElement
) : Element {

    var offset = 0

    private val renderX get() = parent.renderX
    private val renderY get() = parent.renderY + offset

    val width = parent.width
    val height = parent.height

    override fun render(context: DrawContext?, mouseX: Int, mouseY: Int, delta: Float) {
        if (context == null) return

        context.fillRect(renderX, renderY, width, height, Color(60,60,60,255).rgb)
        context.drawTextWithShadow(mc.textRenderer, module.name, renderX, renderY, Color.WHITE.rgb)
    }
}