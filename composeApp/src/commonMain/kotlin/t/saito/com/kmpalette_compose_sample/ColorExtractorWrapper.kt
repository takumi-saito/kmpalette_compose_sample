package t.saito.com.kmpalette_compose_sample

import androidx.compose.ui.graphics.ImageBitmap
import com.kmpalette.palette.graphics.Palette

class ColorExtractorWrapper {
    private val colorExtractor = ColorExtractor()
    fun extractDominantColor(bitmap: ImageBitmap, defaultColor: Int = 0x000000): DominantColor {
        val palette = Palette.from(bitmap).generate()
        return colorExtractor.extractDominantColor(palette, defaultColor)
    }
}