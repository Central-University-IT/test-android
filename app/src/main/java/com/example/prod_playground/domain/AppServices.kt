package com.example.prod_playground.domain

import com.example.prod_playground.core.api.domain.repositories.BannerRepository
import com.example.prod_playground.core.api.domain.repositories.BundlesRepository
import com.example.prod_playground.core.api.domain.repositories.FavoritesRepository
import com.example.prod_playground.core.api.domain.repositories.OffersRepository
import com.example.prod_playground.core.api.domain.repositories.OperationsRepository
import com.example.prod_playground.core.api.domain.repositories.UserInfoRepository
import com.example.prod_playground.core.impl.domain.BannerRepositoryImpl
import com.example.solution.domain.BundlesRepositoryImpl
import com.example.prod_playground.core.impl.domain.DefaultJsonProvider
import com.example.prod_playground.core.impl.domain.FavoritesRepositoryImpl
import com.example.prod_playground.core.impl.domain.OffersRepositoryImpl
import com.example.prod_playground.core.impl.domain.OperationsRepositoryImpl
import com.example.prod_playground.core.impl.domain.UserInfoRepositoryImpl
import com.example.solution.data.sources.remote.BannerRemoteDataSourceImpl
import com.example.prod_playground.core.impl.domain.data.BundlesLocalDataSourceImpl
import com.example.prod_playground.core.impl.domain.data.BundlesRemoteDataSourceImpl
import com.example.solution.data.sources.local.FavoritesLocalDataSourceImpl
import com.example.prod_playground.core.impl.domain.data.OffersRemoteDataSourceImpl
import com.example.solution.data.sources.local.OperationsLocalDataSourceImpl
import com.example.solution.data.sources.remote.OperationsRemoteDataSourceImpl
import com.example.solution.data.sources.local.UserInfoLocalDataSourceImpl
import com.example.solution.data.sources.remote.UserInfoRemoteDataSourceImpl
import com.example.solution.data.api.DefaultBannersApi
import com.example.solution.data.api.DefaultBundlesApi
import com.example.solution.data.api.DefaultOffersApi
import com.example.solution.data.api.DefaultOperationsApi
import com.example.solution.data.api.DefaultUsersApi

object AppServices {

    private val jsonProvider = DefaultJsonProvider()
    private val offersRemoteDataSource = OffersRemoteDataSourceImpl(DefaultOffersApi(jsonProvider))

    val bannerRepository: BannerRepository = BannerRepositoryImpl(
        remoteDataSource = BannerRemoteDataSourceImpl(DefaultBannersApi(jsonProvider))
    )

    val bundlesRepository: BundlesRepository = BundlesRepositoryImpl(
        localDataSource = BundlesLocalDataSourceImpl(),
        remoteDataSource = BundlesRemoteDataSourceImpl(DefaultBundlesApi(jsonProvider))
    )

    val favoritesRepository: FavoritesRepository = FavoritesRepositoryImpl(
        localDataSource = FavoritesLocalDataSourceImpl(),
        offersRemoteDataSource = offersRemoteDataSource
    )

    val offersRepository: OffersRepository = OffersRepositoryImpl(
        offersRemoteDataSource = offersRemoteDataSource
    )

    val operationsRepository: OperationsRepository = OperationsRepositoryImpl(
        remoteDataSource = OperationsRemoteDataSourceImpl(DefaultOperationsApi(jsonProvider)),
        localDataSource = OperationsLocalDataSourceImpl()
    )

    val userInfoRepository: UserInfoRepository = UserInfoRepositoryImpl(
        remoteDataSource = UserInfoRemoteDataSourceImpl(DefaultUsersApi(jsonProvider)),
        localDataSource = UserInfoLocalDataSourceImpl()
    )
}
