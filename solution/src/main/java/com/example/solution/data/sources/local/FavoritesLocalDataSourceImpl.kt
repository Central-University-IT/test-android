package com.example.solution.data.sources.local

import com.example.prod_playground.core.api.data.sources.remote.FavoritesLocalDataSource
import com.example.prod_playground.core.api.domain.models.OfferInfo

/**
 * Задача 6 | Список спецпредложений – логика избранного
 */
class FavoritesLocalDataSourceImpl : FavoritesLocalDataSource {

    override fun getFavoriteOffers(): List<OfferInfo> {
        return emptyList()
    }

    override fun addFavoriteOffer(offer: OfferInfo) = Unit

    override fun removeOfferFromFavorites(offerId: String) = Unit
}