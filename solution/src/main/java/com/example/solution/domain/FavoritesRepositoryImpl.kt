package com.example.solution.domain

import com.example.prod_playground.core.api.data.sources.remote.FavoritesLocalDataSource
import com.example.prod_playground.core.api.data.sources.remote.OffersRemoteDataSource
import com.example.prod_playground.core.api.domain.models.OfferInfo
import com.example.prod_playground.core.api.domain.repositories.FavoritesRepository

class FavoritesRepositoryImpl(
    private val localDataSource: FavoritesLocalDataSource,
    private val offersRemoteDataSource: OffersRemoteDataSource
) : FavoritesRepository {

    override fun getFavoriteOffers(): List<OfferInfo> {
        return emptyList()
    }

    override fun markOfferAsFavourite(offerId: String) = Unit

    override fun checkOfferIsFavorite(offerId: String): Boolean {
        return false
    }

    override fun removeOfferFromFavourites(offerId: String) = Unit
}
