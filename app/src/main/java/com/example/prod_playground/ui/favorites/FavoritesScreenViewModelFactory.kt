package com.example.prod_playground.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prod_playground.domain.AppServices

class FavoritesScreenViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesScreenViewModel::class.java)) {
            return FavoritesScreenViewModel(
                favoritesRepository = AppServices.favoritesRepository,
                userInfoRepository = AppServices.userInfoRepository,
                bundlesRepository = AppServices.bundlesRepository,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
