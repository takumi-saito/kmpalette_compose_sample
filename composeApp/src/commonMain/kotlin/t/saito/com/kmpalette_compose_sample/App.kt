package t.saito.com.kmpalette_compose_sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val urls = Constant.MIX_PHOTO_IMAGE_URLS
    MaterialTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(urls) { url ->
                KMPaletteSampleScreen(url)
            }
        }
    }
}
