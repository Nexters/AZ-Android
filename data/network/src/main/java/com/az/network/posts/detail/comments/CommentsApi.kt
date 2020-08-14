package com.az.network.posts.detail.comments

import com.az.model.posts.detail.comments.CommentsData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentsApi {
    @GET("/v1/api/posts/{postId}/comments")
    suspend fun getComments(
        @Path("postId") postId: Int,
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): CommentsData
}