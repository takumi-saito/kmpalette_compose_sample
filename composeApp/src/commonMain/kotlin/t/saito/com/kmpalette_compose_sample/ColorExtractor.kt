package t.saito.com.kmpalette_compose_sample

import com.kmpalette.palette.graphics.Palette

class ColorExtractor {
    @OptIn(ExperimentalStdlibApi::class)
    fun extractDominantColor(palette: Palette, defaultColor: Int = 0x000000): DominantColor {
        val intColor = palette.dominantSwatch?.rgb ?: defaultColor
        val intTitleColor = palette.dominantSwatch?.titleTextColor ?: defaultColor.inv()
        return DominantColor(
            color = colorIntToHex(intColor, includeAlpha = true),
            titleColor =  colorIntToHex(intTitleColor, includeAlpha = true),
        ).also {
            println("DominantColor: $it")
        }
    }

    @ExperimentalStdlibApi
    fun colorIntToHex(colorInt: Int, includeAlpha: Boolean = true): String {
        val hexFormat = HexFormat {
            upperCase = true // 大文字の16進表記
            number {
                prefix = "#" // 色コードの先頭に # を追加
                removeLeadingZeros = false // 必ずフル桁数で出力
            }
        }

        return if (includeAlpha) {
            // アルファ値を含める (AARRGGBB形式)
            hexFormat.number.prefix + colorInt.toUInt().toString(16).padStart(8, '0')
        } else {
            // アルファ値を除外する (RRGGBB形式)
            hexFormat.number.prefix + (colorInt and 0xFFFFFF).toString(16).padStart(6, '0')
        }
    }

}

