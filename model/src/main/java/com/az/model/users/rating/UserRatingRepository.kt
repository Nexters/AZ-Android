package com.az.model.users.rating

import com.az.model.Resource

interface UserRatingRepository {
    suspend fun getUserRating(userId: Int): Resource<UserRatingData>
}