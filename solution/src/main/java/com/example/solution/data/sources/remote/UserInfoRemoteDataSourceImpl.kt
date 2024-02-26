package com.example.solution.data.sources.remote

import com.example.prod_playground.core.api.data.api.UsersApi
import com.example.prod_playground.core.api.data.sources.remote.UserInfoRemoteDataSource
import com.example.prod_playground.core.api.domain.models.UserInfo

/**
 * Задача 2 | Виджет пользователя – получение данных
 */
class UserInfoRemoteDataSourceImpl(private val api: UsersApi) : UserInfoRemoteDataSource {

    override fun getUserInfo(): UserInfo {
        TODO()
    }
}