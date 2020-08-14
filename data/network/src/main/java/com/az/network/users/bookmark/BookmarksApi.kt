package com.az.network.users.bookmark

import com.az.model.users.bookmark.BookmarksData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookmarksApi {
    @GET("/v1/api/users/{userId}/bookmark/posts")
    suspend fun getBookmarks(
        @Path("userId") userId: Int,
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): BookmarksData
}