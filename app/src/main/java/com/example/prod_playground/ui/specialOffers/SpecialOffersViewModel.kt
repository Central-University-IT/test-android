package com.example.prod_playground.ui.specialOffers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prod_playground.core.api.domain.models.BannerItem
import com.example.prod_playground.core.api.domain.repositories.BannerRepository
import com.example.prod_playground.core.api.domain.repositories.BundlesRepository
import com.example.prod_playground.core.api.domain.repositories.FavoritesRepository
import com.example.prod_playground.core.api.domain.repositories.OffersRepository
import com.example.prod_playground.core.api.domain.repositories.OperationsRepository
import com.example.prod_playground.core.api.domain.repositories.UserInfoRepository
import com.example.solution.entities.SpecialOfferUiItem
import com.example.solution.entities.UserInfoUiModel
import com.example.solution.mappers.SpecialOfferDataToUiModelMapper
import com.example.solution.mappers.UserInfoToUiModelMapper

class SpecialOffersViewModel(
    private val favoritesRepository: FavoritesRepository,
    private val bannerRepository: BannerRepository,
    private val bundlesRepository: BundlesRepository,
    private val offersRepository: OffersRepository,
    private val userInfoRepository: UserInfoRepository,
    private val operationsRepository: OperationsRepository,
) : ViewModel() {

    private val _specialOffersListLiveData = MutableLiveData<List<SpecialOfferUiItem>>()
    val specialOffersListLiveData: LiveData<List<SpecialOfferUiItem>>
        get() = _specialOffersListLiveData

    private val _bannerInfoLiveData = MutableLiveData<BannerItem>()
    val bannerInfoLiveData: LiveData<BannerItem>
        get() = _bannerInfoLiveData

    private val _userInfoLiveData = MutableLiveData<UserInfoUiModel>()
    val userInfoLiveData: LiveData<UserInfoUiModel>
        get() = _userInfoLiveData

    private val _favoritesBadgeCountLiveData = MutableLiveData<Int>()
    val favoritesBadgeCountLiveData: LiveData<Int>
        get() = _favoritesBadgeCountLiveData

    private var currentOffersList: MutableList<SpecialOfferUiItem> = mutableListOf()

    private val _updateSpecialOffersListLiveData = MutableLiveData<Int>()
    val updateSpecialOffersListLiveData: LiveData<Int>
        get() = _updateSpecialOffersListLiveData

    init {
        getPromoBannerInfo()
        getUserInfo()
    }

    fun onLikeClick(offerId: String, position: Int) {
        val isFavorite = favoritesRepository.checkOfferIsFavorite(offerId)

        if (isFavorite) {
            favoritesRepository.removeOfferFromFavourites(offerId)
        } else {
            favoritesRepository.markOfferAsFavourite(offerId)
        }

        getFavoritesBadgeCount()

        currentOffersList[position] = currentOffersList[position].copy(
            isFavorite = !isFavorite
        )

        updateOfferList(position)
    }

    fun getFavoritesBadgeCount() {
        val favoritesBadgeCount = favoritesRepository.getFavoriteOffers().size
        _favoritesBadgeCountLiveData.postValue(favoritesBadgeCount)
    }

    fun getSpecialOffersList() {
        val offersInfo = offersRepository.getOffers()
        val userInfo = userInfoRepository.getUserInfo()
        currentOffersList = SpecialOfferDataToUiModelMapper(
            favoritesRepository = favoritesRepository,
            bundlesRepository = bundlesRepository,
        ).invoke(
            offersInfo = offersInfo,
            userInfo = userInfo,
        ).toMutableList()

        _specialOffersListLiveData.postValue(currentOffersList)
    }

    private fun getPromoBannerInfo() {
        val bannerItem = bannerRepository.getBanner()
        bannerItem?.let { item ->
            _bannerInfoLiveData.postValue(item)
        }
    }

    private fun getUserInfo() {
        val userInfo = userInfoRepository.getUserInfo()
        val operations = operationsRepository.getOperations()
        val userInfoUiModel = UserInfoToUiModelMapper().invoke(
            operations = operations,
            userInfo = userInfo
        )

        _userInfoLiveData.postValue(userInfoUiModel)
    }

    private fun updateOfferList(position: Int) {
        _updateSpecialOffersListLiveData.postValue(position)
    }
}
