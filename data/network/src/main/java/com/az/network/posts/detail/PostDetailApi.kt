package com.az.network.posts.detail

import com.az.model.posts.detail.PostDetailData
import retrofit2.http.GET
import retrofit2.http.Path

interface PostDetailApi {
    @GET("/v1/api/posts/{postId}")
    suspend fun getPosts(
        @Path("postId") postId: Int
    ): PostDetailData
}