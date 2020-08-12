package com.az.network.users.rating

import com.az.core.Resource
import com.az.model.users.rating.UserRatingData

interface UserRatingRemoteDataSource {
    suspend fun getUserRating(userId: Int): Resource<UserRatingData>
}