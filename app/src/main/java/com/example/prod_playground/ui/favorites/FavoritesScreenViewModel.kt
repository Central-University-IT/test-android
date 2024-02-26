package com.example.prod_playground.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prod_playground.core.api.domain.repositories.BundlesRepository
import com.example.prod_playground.core.api.domain.repositories.FavoritesRepository
import com.example.prod_playground.core.api.domain.repositories.UserInfoRepository
import com.example.solution.entities.SpecialOfferUiItem
import com.example.solution.mappers.SpecialOfferDataToUiModelMapper

class FavoritesScreenViewModel(
    private val favoritesRepository: FavoritesRepository,
    private val userInfoRepository: UserInfoRepository,
    private val bundlesRepository: BundlesRepository,
) : ViewModel() {

    private val _favoritesOffersListLiveData = MutableLiveData<List<SpecialOfferUiItem>>()
    val favoritesOffersListLiveData: LiveData<List<SpecialOfferUiItem>>
        get() = _favoritesOffersListLiveData

    private var currentOffersList: MutableList<SpecialOfferUiItem> = mutableListOf()

    private val _updateSpecialOffersListLiveData = MutableLiveData<Int>()
    val updateSpecialOffersListLiveData: LiveData<Int>
        get() = _updateSpecialOffersListLiveData

    init {
        getFavoritesList()
    }

    fun onLikeClick(offerId: String, position: Int) {
        favoritesRepository.removeOfferFromFavourites(offerId)
        currentOffersList.removeAt(position)
        updateOfferList(position)
    }

    private fun updateOfferList(position: Int) {
        _updateSpecialOffersListLiveData.postValue(position)
    }

    private fun getFavoritesList() {
        currentOffersList = SpecialOfferDataToUiModelMapper(
            favoritesRepository = favoritesRepository,
            bundlesRepository = bundlesRepository,
        ).invoke(
            favoritesRepository.getFavoriteOffers(),
            userInfoRepository.getUserInfo(),
        ).toMutableList()

        _favoritesOffersListLiveData.postValue(currentOffersList)
    }
}
