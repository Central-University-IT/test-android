package com.example.solution.data.sources.remote

import com.example.prod_playground.core.api.data.api.BannersApi
import com.example.prod_playground.core.api.data.sources.remote.BannerRemoteDataSource
import com.example.prod_playground.core.api.domain.models.BannerItem

/**
 * Задача 1 | Рекламный баннер – получение данных
 */
class BannerRemoteDataSourceImpl(private val api: BannersApi) : BannerRemoteDataSource {

    override fun getBanner(): BannerItem? {
        return null
    }
}