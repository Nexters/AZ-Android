package com.az.network.users.posts

import com.az.model.posts.PostsData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserPostsApi {
    @GET("/v1/api/users/{userId}/posts")
    suspend fun getPosts(
        @Path("userId") userId: Int,
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): PostsData
}