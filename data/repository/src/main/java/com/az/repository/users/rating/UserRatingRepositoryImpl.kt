package com.az.repository.users.rating

import com.az.core.Resource
import com.az.model.users.rating.UserRatingData
import com.az.model.users.rating.UserRatingRepository
import com.az.network.users.rating.UserRatingRemoteDataSource

class UserRatingRepositoryImpl(
    private val userRatingRemoteDataSource: UserRatingRemoteDataSource
) : UserRatingRepository {
    override suspend fun getUserRating(userId: Int): Resource<UserRatingData> {
        return userRatingRemoteDataSource.getUserRating(userId)
    }
}