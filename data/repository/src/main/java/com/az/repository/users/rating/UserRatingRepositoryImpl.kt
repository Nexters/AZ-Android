package com.az.repository.users.rating

import com.az.model.Resource
import com.az.model.users.rating.UserRatingData
import com.az.model.users.rating.UserRatingRepository
import com.az.network.users.rating.UserRatingRemoteDataSource
import org.koin.dsl.module

val userRatingRepositoryModule = module {
    single<UserRatingRepository> { UserRatingRepositoryImpl(get()) }
}

class UserRatingRepositoryImpl(
    private val userRatingRemoteDataSource: UserRatingRemoteDataSource
) : UserRatingRepository {
    override suspend fun getUserRating(userId: Int): Resource<UserRatingData> {
        return userRatingRemoteDataSource.getUserRating(userId)
    }
}