package com.az.network.posts

import com.az.model.posts.PostsData

interface PostsRemoteDataSource {
    // TODO: onResponse, onFailure 부분 추상화하기
    fun getPosts(
        currentPage: Int,
        size: Int,
        onSuccess: (response: PostsData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}