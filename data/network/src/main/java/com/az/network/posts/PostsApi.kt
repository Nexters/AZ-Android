package com.az.network.posts

import com.az.model.posts.PostsData
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {
    @GET("/v1/api/posts")
    suspend fun getPosts(
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): PostsData
}