package com.olaf.model.repository

import com.olaf.model.GithubUserInfo

interface GithubRepository {
    fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfo) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}