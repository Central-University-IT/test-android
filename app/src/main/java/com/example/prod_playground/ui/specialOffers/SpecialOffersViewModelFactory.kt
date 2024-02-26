package com.example.prod_playground.ui.specialOffers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prod_playground.domain.AppServices

@Suppress("UNCHECKED_CAST")
class SpecialOffersViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SpecialOffersViewModel::class.java)) {
            return SpecialOffersViewModel(
                favoritesRepository = AppServices.favoritesRepository,
                bannerRepository = AppServices.bannerRepository,
                offersRepository = AppServices.offersRepository,
                userInfoRepository = AppServices.userInfoRepository,
                operationsRepository = AppServices.operationsRepository,
                bundlesRepository = AppServices.bundlesRepository,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
