package com.olaf.repository

import com.olaf.model.post.GithubUserInfoData
import com.olaf.model.post.GithubRepository
import com.olaf.network.GithubRemoteDataSource

class GithubRepositoryImpl(
    private val githubApi: GithubRemoteDataSource
) : GithubRepository {

    override fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfoData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        githubApi.getUserInfo(name, onSuccess, onFailure)
    }
}