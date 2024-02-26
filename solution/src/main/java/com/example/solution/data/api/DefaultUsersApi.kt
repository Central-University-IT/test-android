package com.example.solution.data.api

import com.example.prod_playground.core.api.data.api.UsersApi
import com.example.prod_playground.core.api.data.json.JsonProvider
import com.example.prod_playground.core.api.domain.models.UserInfo

/**
 * Задача 2 | Виджет пользователя – получение данных
 */
class DefaultUsersApi(private val jsonProvider: JsonProvider) : UsersApi {

    override fun getUser(userId: String): UserInfo {
        TODO()
    }
}