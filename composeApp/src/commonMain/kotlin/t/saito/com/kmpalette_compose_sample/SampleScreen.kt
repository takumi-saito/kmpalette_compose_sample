package t.saito.com.kmpalette_compose_sample

import androidx.annotation.ColorInt
import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kmpalette.loader.rememberNetworkLoader
import com.kmpalette.rememberDominantColorState
import io.ktor.http.Url


@OptIn(ExperimentalStdlibApi::class)
@Composable
fun KMPaletteSampleScreen(url: String) {
    var dominantColor by remember { mutableStateOf<DominantColor>(DominantColor.default) }
    println("Dominant color: $dominantColor")
    Row {
        KMPaletteForNetworkLoader(url, modifier = Modifier.weight(1f))
        KMPaletteForImageBitmap(url, modifier = Modifier.weight(1f))
    }
}

/**
 * NetworkLoaderでDominantColorを取得して、画像とDominantColorを表示する
 */
@OptIn(ExperimentalStdlibApi::class)
@Composable
fun KMPaletteForNetworkLoader(url: String, modifier: Modifier = Modifier) {
    val networkLoader = rememberNetworkLoader()
    val dominantColorState = rememberDominantColorState(loader = networkLoader)
    LaunchedEffect(url) {
        dominantColorState.updateFrom(Url(url))
    }

    Row(
        modifier = modifier.background(dominantColorState.color),
        verticalAlignment = Alignment.CenterVertically)
    {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black),
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(8.dp),
            text = "#" + dominantColorState.color.toArgb().toHexString(),
            style = TextStyle(
                fontSize = 14.sp,
                color = dominantColorState.onColor
            )
        )
    }
}

/**
 * ImageBitmapでDominantColorを取得して、画像とDominantColorを表示する
 */
@Composable
fun KMPaletteForImageBitmap(url: String, modifier: Modifier = Modifier) {
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var dominantColor by remember { mutableStateOf<DominantColor>(DominantColor.default) }
    LaunchedEffect(url) {
        imageBitmap = fetchImageBitmap(url)
        dominantColor = ColorExtractorWrapper().extractDominantColor(imageBitmap!!)
    }

    Row(
        modifier = modifier.background(Color(parseColor(dominantColor.color))),
        verticalAlignment = Alignment.CenterVertically)
    {
        imageBitmap?.let {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                bitmap = it,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(8.dp),
                text = dominantColor.color,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(parseColor(dominantColor.titleColor))
                )
            )
        }
    }
}

@ColorInt
fun parseColor(@Size(min = 1) colorString: String): Int {
    if (colorString[0] == '#') {
        // Use a long to avoid rollovers on #ffXXXXXX
        var color = colorString.substring(1).toLong(16)
        if (colorString.length == 7) {
            // Set the alpha value
            color = color or 0x00000000ff000000L
        } else require(colorString.length == 9) { "Unknown color" }
        return color.toInt()
    } else {
        throw IllegalArgumentException("Unknown color")
    }
}
