package com.az.network.posts.popular

import com.az.model.posts.PostsData
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsPopularApi {
    @GET("/v1/api/posts/popular")
    suspend fun getPopularPosts(
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): PostsData
}