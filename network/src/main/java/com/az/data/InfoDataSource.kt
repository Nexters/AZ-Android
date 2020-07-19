package com.az.data

import com.az.vo.github.GitHubVO
import retrofit2.Response

interface InfoDataSource {
    suspend fun getInfo(name: String): Response<GitHubVO>
}