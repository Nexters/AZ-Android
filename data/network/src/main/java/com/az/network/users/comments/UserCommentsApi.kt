package com.az.network.users.comments

import com.az.model.posts.detail.comments.CommentsData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserCommentsApi {
    @GET("/v1/api/users/{userId}/comments")
    suspend fun getComments(
        @Path("userId") userId: Int,
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): CommentsData

}