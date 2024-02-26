package com.example.solution.data.api

import com.example.prod_playground.core.api.data.api.BundlesApi
import com.example.prod_playground.core.api.data.json.JsonProvider
import com.example.prod_playground.core.api.domain.models.BundleInfo

/**
 * Задача 4 | Список спецпредложений – получение данных
 */
class DefaultBundlesApi(private val jsonProvider: JsonProvider) : BundlesApi {

    override fun getBundles(): List<BundleInfo> {
        return emptyList()
    }
}