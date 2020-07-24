package com.olaf.network

import com.olaf.model.GithubUserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{name}")
    fun getUserInfo(
        @Path("name") name: String
    ): Call<GithubUserInfo>
}