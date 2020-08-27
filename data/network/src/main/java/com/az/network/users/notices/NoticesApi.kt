package com.az.network.users.notices

import com.az.model.users.notices.NoticesData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NoticesApi {
    @GET("/v1/api/users/{userId}/notices")
    suspend fun getNotices(
        @Path("userId") userId: Int,
        @Query("currentPage") currentPage: Int,
        @Query("size") size: Int
    ): NoticesData
}