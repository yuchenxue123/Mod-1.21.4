package com.yuchenxue.ui.screen.clickgui

import com.yuchenxue.module.ClientModule
import com.yuchenxue.ui.api.ScreenElement
import com.yuchenxue.utils.extensions.fillRect
import net.minecraft.client.gui.DrawContext
import java.awt.Color

/**
 * @author yuchenxue
 * @date 2025/01/13 - 13:52
 */

class ModuleButton(
    val module: ClientModule,
    val parent: CategoryScreen
) : ScreenElement {

    var offset = 0

    private val renderX
        get() = parent.renderX
    private val renderY
        get() = parent.renderY + offset

    val width = parent.width
    val height = parent.height

    private var open = false
        set(value) {
            field = value
        }

    override fun render(context: DrawContext, mouseX: Int, mouseY: Int, delta: Float) {
        val color = if (module.state) Color(120, 120, 120, 255).rgb else Color(60,60,60,255).rgb
        context.fillRect(renderX, renderY, width, height, color)

        val text = module.name
        context.drawTextWithShadow(
            font,
            text,
            renderX + (width - font.getWidth(text)) / 2,
            renderY + (height - fontHeight) / 2,
            Color.WHITE.rgb
        )
    }

    override fun mouseClicked(mouseX: Double, mouseY: Double, button: Int) {
        val hovered = isHovered(renderX, renderY, width, height, mouseX, mouseY)
        if (hovered) {
            if (button == 0 && module.canEnable) {
                module.toggle()
            }
            if (button == 1) {
                open = !open
            }
        }
    }
}