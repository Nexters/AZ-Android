package com.az.model.users.rating

interface UserRatingRepository {
    // TODO: onResponse, onFailure 부분 추상화하기
    fun getUserRating(
        userId: Int,
        onSuccess: (response: UserRatingData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}