package t.saito.com.kmpalette_compose_sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform