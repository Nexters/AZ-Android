package com.az.network.users.rating

import com.az.model.users.rating.UserRatingData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRatingApi {
    @GET("/v1/api/users/{userId}/rating")
    fun getPosts(
        @Path("userId") userId: Int
    ): Call<UserRatingData>
}