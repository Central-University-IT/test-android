package com.example.prod_playground.ui.offerInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prod_playground.domain.AppServices

class OfferInfoViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OfferInfoViewModel::class.java)) {
            return OfferInfoViewModel(
                favoritesRepository = AppServices.favoritesRepository,
                offersRepository = AppServices.offersRepository,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
