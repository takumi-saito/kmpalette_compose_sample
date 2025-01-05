package t.saito.com.kmpalette_compose_sample

data class DominantColor(
    val color: String,
    val titleColor: String
) {
    companion object {
        val default = DominantColor(
            color = "#000000",
            titleColor = "#FFFFFF"
        )
    }
}