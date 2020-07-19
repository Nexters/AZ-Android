package com.az.api

import com.az.vo.github.GitHubVO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GitHubAPI {

    @GET("users/{name}")
    suspend fun getUser(
        @Path("name") name: String
    ): Response<GitHubVO>
}