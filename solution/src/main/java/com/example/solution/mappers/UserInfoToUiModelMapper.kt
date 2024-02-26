package com.example.solution.mappers

import com.example.prod_playground.core.api.domain.models.OperationInfo
import com.example.prod_playground.core.api.domain.models.UserInfo
import com.example.solution.entities.UserInfoUiModel

/**
 * Задача 3 | Компонент "Полная информация о пользователе" – логика и подготовка отображения
 */
class UserInfoToUiModelMapper : (List<OperationInfo>, UserInfo) -> UserInfoUiModel {

    override fun invoke(operations: List<OperationInfo>, userInfo: UserInfo): UserInfoUiModel {

        //TODO add logic

        return UserInfoUiModel(
            userName = "",
            balance = "",
            specialPoints = "",
        )
    }
}
