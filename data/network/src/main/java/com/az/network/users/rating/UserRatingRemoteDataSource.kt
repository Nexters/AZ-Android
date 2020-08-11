package com.az.network.users.rating

import com.az.model.users.rating.UserRatingData

interface UserRatingRemoteDataSource {
    // TODO: onResponse, onFailure 부분 추상화하기
    fun getUserRating(
        userId: Int,
        onSuccess: (response: UserRatingData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}