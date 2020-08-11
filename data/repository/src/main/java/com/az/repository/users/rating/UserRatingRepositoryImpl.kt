package com.az.repository.users.rating

import com.az.model.users.rating.UserRatingData
import com.az.model.users.rating.UserRatingRepository
import com.az.network.users.rating.UserRatingRemoteDataSource
import org.koin.dsl.module

val userRatingRepositoryModule = module {
    single<UserRatingRepository> { UserRatingRepositoryImpl(get()) }
}

class UserRatingRepositoryImpl(
    private val userRatingApi: UserRatingRemoteDataSource
) : UserRatingRepository {
    override fun getUserRating(
        userId: Int,
        onSuccess: (response: UserRatingData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        userRatingApi.getUserRating(userId, onSuccess, onFailure)
    }
}