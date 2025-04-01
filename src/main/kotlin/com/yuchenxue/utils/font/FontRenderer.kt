package com.yuchenxue.utils.font

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.util.Identifier
import java.awt.*
import java.awt.image.BufferedImage
import java.util.*
import kotlin.math.max


/**
 * @author yuchenxue
 * @date 2025/04/01
 */

class FontRenderer(private var font: Font) {
    private var metrics: FontMetrics = generateFontMetrics()

    fun load(font: Font) = apply {
        this.font = font
        metrics = generateFontMetrics()
    }

    private val bakedStaticStringList: HashMap<String, Identifier> = HashMap<String, Identifier>()

    fun drawStaticString(graphics: Graphics2D, text: String, pos: Vector<*>, color: Color) {

        val resourceLocation: Identifier
        if (bakedStaticStringList.containsKey(text)) {
            resourceLocation = bakedStaticStringList[text]!!
        } else {
            resourceLocation = Identifier.of("stay", UUID.randomUUID().toString())
            val img = getBufferedImage(text)
            if (img != null) {
//                val tex: DynamicTexture = TextureUtil.getDynamicTexture(img)
//                tex.upload()
//                mc.textureManager.registerTexture(resourceLocation, tex)
            }
            bakedStaticStringList[text] = resourceLocation
        }

        val width = metrics.stringWidth(text)
        val height = metrics.height
        val yOff = 2
        RenderSystem.setShaderColor(color.red / 255f, color.green / 255f, color.blue / 255f, color.alpha / 255f)
//        DrawUtil.drawTexturedRect(
//            graphics,
//            resourceLocation,
//            pos.getSubtracted(0, yOff),
//            Vector(width, height)
//        )
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f)
    }

    private fun getBufferedImage(text: String): BufferedImage? {
        if (text.isEmpty()) {
            return null
        }
        val width = max(1, metrics.stringWidth(text))
        val height = max(1, metrics.height)
        return getBufferedImage(width, height) { graphics ->
            graphics.font = font
            graphics.color = Color.WHITE

            graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON)
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

            var x = 0
            for (c in text.toCharArray()) {
                graphics.drawString(c.toString(), x, metrics.ascent)
                x += metrics.stringWidth(c.toString())
            }
        }
    }

    private fun generateFontMetrics(): FontMetrics {
        val tempImage = BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)
        val graphics = tempImage.graphics
        graphics.font = font
        return graphics.fontMetrics
    }

    private fun getBufferedImage(width: Int, height: Int, drawCode: (Graphics2D) -> Unit): BufferedImage {
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val graphics = image.graphics as Graphics2D
        drawCode.invoke(graphics)
        return image
    }
}