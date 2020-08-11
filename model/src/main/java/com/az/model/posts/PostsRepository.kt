package com.az.model.posts

interface PostsRepository {
    // TODO: onResponse, onFailure 부분 추상화하기
    fun getPosts(
        currentPage: Int,
        size: Int,
        onSuccess: (response: PostsData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}