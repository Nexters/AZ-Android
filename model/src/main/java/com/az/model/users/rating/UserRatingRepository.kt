package com.az.model.users.rating

import com.az.model.posts.PostsData

interface UserRatingRepository{
    // TODO: onResponse, onFailure 부분 추상화하기
    fun getUserRating(
        userId: Int,
        onSuccess: (response: PostsData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}