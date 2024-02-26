package com.example.solution.data.api

import com.example.prod_playground.core.api.data.api.BannersApi
import com.example.prod_playground.core.api.data.json.JsonProvider
import com.example.prod_playground.core.api.domain.models.BannerItem

/**
 * Задача 1 | Рекламный баннер – получение данных
 */
class DefaultBannersApi(private val jsonProvider: JsonProvider) : BannersApi {

    override fun getBanner(): BannerItem? {
        return null
    }


}