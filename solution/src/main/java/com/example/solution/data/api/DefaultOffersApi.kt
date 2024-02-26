package com.example.solution.data.api

import com.example.prod_playground.core.api.data.api.OffersApi
import com.example.prod_playground.core.api.data.json.JsonProvider
import com.example.prod_playground.core.api.domain.models.OfferFullInfo
import com.example.prod_playground.core.api.domain.models.OfferInfo

/**
 * Задача 4 | Список спецпредложений – получение данных
 */
class DefaultOffersApi(private val jsonProvider: JsonProvider) : OffersApi {

    override fun getOffers(
        userId: String,
        location: String,
        recommendation: Boolean
    ): List<OfferInfo> {
        return emptyList()
    }

    override fun getFullOffer(id: String, userId: String): OfferFullInfo {
        TODO()
    }
}