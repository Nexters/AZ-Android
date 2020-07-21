package com.az.data

import com.az.api.GitHubAPI
import com.az.vo.github.GitHubVO
import retrofit2.Call
import retrofit2.Response

internal class InfoDataSourceImpl(private val gitHubAPI: GitHubAPI) : InfoDataSource {
    override suspend fun getInfo(name: String): Response<GitHubVO> = gitHubAPI.getUser(name)
}