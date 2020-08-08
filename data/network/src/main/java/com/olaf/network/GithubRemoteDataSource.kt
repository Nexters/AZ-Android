package com.olaf.network

import com.olaf.model.post.GithubUserInfoData

interface GithubRemoteDataSource {
    fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfoData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}