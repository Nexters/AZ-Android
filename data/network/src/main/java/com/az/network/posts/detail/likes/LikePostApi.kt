package com.az.network.posts.detail.likes

import com.az.model.posts.detail.likes.LikePostResponseData
import retrofit2.http.POST
import retrofit2.http.Path

interface LikePostApi {
    @POST("/v1/api/posts/{postId}/likes")
    suspend fun likePost(
        @Path("postId") postId: Int
    ): LikePostResponseData
}