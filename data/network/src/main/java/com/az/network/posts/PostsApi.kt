package com.az.network.posts

import com.az.model.posts.PostsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {
    @GET("/v1/api/posts")
    fun getPosts(
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): Call<PostsData>
}