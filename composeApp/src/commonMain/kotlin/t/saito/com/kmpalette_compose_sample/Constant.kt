package t.saito.com.kmpalette_compose_sample

object Constant {
    fun imageUrls(): List<String> {
        return (10..15).map {
            "https://picsum.photos/id/$it/200/200"
        }
    }

    val REAL_PHOTO_IMAGE_URLS: List<String> = (10..15).map {
        "https://picsum.photos/id/$it/200/200"
    }

    val SIMPLE_IMAGE_URLS: List<String> = listOf(
        "https://placehold.jp/3d4070/ffffff/150x150.png",
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhgNtjUoPS1OnOND9jZZZVSvLsakts3pL5u-FdpE31eWGbgTvAGLbsvNDpApHgJgnSrfwCAljqMyKBzVX6O6gQry0xGzY7jyJBO8Hq0j8ZtlaFvTXLAHqJwcUpAYhfrma-bz7M-WHdaIc1_/s800/sweets_macaroon.png",
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEib_aNImB4YeHc74m6gzwDrVWWWWQG5fBmB_pP_Q1yq1GMuM9vyEJMB7dyCQT-UxQYfw986zxut2N3HewrDOuBw4XM5E45nV_-zSSAqsJ4AG6EEUV7jesvxb-LoBXywW9Yhxx5JkSs2Ttg/s800/hebi.png",
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjdDLh96RwvtH6EBM5V9ea2BtUaiC2Hn7U2O9BiKMPbKWHbXAECOtm-1qp22AywlwJZ6YL2MrUSHUPTWmjnfAm7dof8yDakkXDO-mF_yjPa30_ucVlXPGPTM5jEOd7oR1QSSvJsqk9yBxxR/s496/food_naruto_danmen.png",
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgRp4xSigzCh7jg0XWm4nYxAOZm2gTX5VMdqoA7HiFo0pQMWmtIxbwC4xn6r_mB2_l15kcTQdW4Kau_ZPIBDtpEUDiHuV-PjUp1VGgM7RRKyEzdU29Lubrn8rOV5UMNCrxH7cJRbRbPYyHj/s800/lgbt_rainbow_heart.png",
    )

    val MIX_PHOTO_IMAGE_URLS: List<String> = mutableListOf<String>()
        .apply {
            addAll(REAL_PHOTO_IMAGE_URLS)
            addAll(SIMPLE_IMAGE_URLS)
        }
}