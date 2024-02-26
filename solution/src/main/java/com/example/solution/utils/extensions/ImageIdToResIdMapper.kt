package com.example.solution.utils.extensions

import com.example.solution.R


fun imageIdToResId(imageId: String): Int {
    return when (imageId) {
        "banner_image" -> R.drawable.promo_banner_image
        "offer_cart_123" -> R.drawable.offer_card_image
        else -> 0
    }
}
