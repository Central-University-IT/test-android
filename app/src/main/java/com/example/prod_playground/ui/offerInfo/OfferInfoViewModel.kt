package com.example.prod_playground.ui.offerInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prod_playground.core.api.domain.models.OfferFullInfo
import com.example.prod_playground.core.api.domain.repositories.FavoritesRepository
import com.example.prod_playground.core.api.domain.repositories.OffersRepository

class OfferInfoViewModel(
    private val offersRepository: OffersRepository,
    private val favoritesRepository: FavoritesRepository,
) : ViewModel() {

    private val _offerFullInfoLiveData = MutableLiveData<OfferFullInfo>()
    val offerFullInfoLiveData: LiveData<OfferFullInfo>
        get() = _offerFullInfoLiveData

    private val _isFavoritesLiveData = MutableLiveData<Boolean>()
    val isFavoritesLiveData: LiveData<Boolean>
        get() = _isFavoritesLiveData

    fun onAddToFavoriteButtonClick(offerId: String) {
        val isFavorites = isFavoritesCheck(offerId)
        if(isFavorites) {
            removeOfferFromFavourites(offerId)
        } else {
            markOfferAsFavourite(offerId)
        }

        favoritesCheckPostValue(offerId)
    }

    fun getOfferFullInfo(id: String) {
        val item = offersRepository.getOfferFullInfo(id)
        _offerFullInfoLiveData.postValue(item)
    }

    fun favoritesCheckPostValue(id: String) {
        val isFavorites = isFavoritesCheck(id)
        _isFavoritesLiveData.postValue(isFavorites)
    }

    private fun removeOfferFromFavourites(offerId: String) {
        favoritesRepository.removeOfferFromFavourites(offerId)
    }

    private fun markOfferAsFavourite(offerId: String) {
        favoritesRepository.markOfferAsFavourite(offerId)
    }

    private fun isFavoritesCheck(id: String) : Boolean {
        return favoritesRepository.getFavoriteOffers().any { it.id == id }
    }
}
