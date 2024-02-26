package com.example.solution.entities

import com.example.prod_playground.core.api.domain.models.BundleInfo

data class SpecialOfferUiItem(
    val id: String,
    val title: String,
    val description: String,
    val bonusValue: String,
    val bgColorHex: String,
    val imageId: String,
    val isFavorite: Boolean,
    val bundle: BundleInfo?,
)
