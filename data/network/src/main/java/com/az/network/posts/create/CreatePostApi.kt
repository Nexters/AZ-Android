package com.az.network.posts.create

import com.az.model.posts.create.CreatePostRequestData
import com.az.model.posts.create.CreatePostResponseData
import retrofit2.http.Body
import retrofit2.http.POST

interface CreatePostApi {
    @POST("/v1/api/posts/post")
    suspend fun createPost(
        @Body request: CreatePostRequestData
    ): CreatePostResponseData
}