package com.olaf.network

import com.olaf.model.GithubUserInfo

interface GithubRemoteDataSource {
    fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfo) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}