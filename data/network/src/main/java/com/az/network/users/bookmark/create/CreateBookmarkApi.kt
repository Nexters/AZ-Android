package com.az.network.users.bookmark.create

import com.az.model.users.bookmark.create.CreateBookmarkResponseData
import retrofit2.http.POST
import retrofit2.http.Path

interface CreateBookmarkApi {
    @POST("/v1/api/users/bookmark/posts/{postId}")
    suspend fun addBookmark(
        @Path("postId") postId: Int
    ): CreateBookmarkResponseData
}