package com.olaf.model.post

interface GithubRepository {
    fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfoData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}