package com.az.data

import com.az.api.GitHubAPI
import com.az.vo.github.GitHubVO
import retrofit2.Response
import retrofit2.Retrofit

internal class InfoDataSourceImpl(val retrofit: Retrofit) : InfoDataSource {
    override suspend fun getInfo(name: String): Response<GitHubVO> =
        retrofit.create(GitHubAPI::class.java)
            .getUser(name)
}