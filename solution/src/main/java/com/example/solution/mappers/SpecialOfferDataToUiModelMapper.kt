package com.example.solution.mappers

import com.example.prod_playground.core.api.domain.models.OfferInfo
import com.example.prod_playground.core.api.domain.models.UserInfo
import com.example.prod_playground.core.api.domain.repositories.BundlesRepository
import com.example.prod_playground.core.api.domain.repositories.FavoritesRepository
import com.example.solution.entities.SpecialOfferUiItem

/**
 * Задача 5 | Список спецпредложений – логика, обработка данных и подготовка отображения
 */
class SpecialOfferDataToUiModelMapper(
    private val favoritesRepository: FavoritesRepository,
    private val bundlesRepository: BundlesRepository,
) : (List<OfferInfo>, UserInfo) -> List<SpecialOfferUiItem> {
    override fun invoke(
        offersInfo: List<OfferInfo>,
        userInfo: UserInfo,
    ): List<SpecialOfferUiItem> {

        //TODO add logic

        return emptyList()
    }
}
