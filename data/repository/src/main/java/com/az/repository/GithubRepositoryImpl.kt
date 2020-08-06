package com.olaf.repository

import com.olaf.model.GithubUserInfo
import com.olaf.model.repository.GithubRepository
import com.olaf.network.GithubRemoteDataSource

class GithubRepositoryImpl(
    private val githubApi: GithubRemoteDataSource
) : GithubRepository {

    override fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfo) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        githubApi.getUserInfo(name, onSuccess, onFailure)
    }
}