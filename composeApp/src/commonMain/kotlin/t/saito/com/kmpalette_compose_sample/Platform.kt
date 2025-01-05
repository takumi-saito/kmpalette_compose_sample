package t.saito.com.kmpalette_compose_sample

import androidx.compose.ui.graphics.ImageBitmap

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect suspend fun fetchImageBitmap(url: String): ImageBitmap?