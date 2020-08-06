package com.olaf.network

import com.olaf.model.GithubUserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class GithubRemoteDataSourceImpl(
    private val githubApi: GithubApi
) : GithubRemoteDataSource {
    override fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfo) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        githubApi.getUserInfo(name).enqueue(object : Callback<GithubUserInfo> {
            override fun onResponse(
                call: Call<GithubUserInfo>,
                response: Response<GithubUserInfo>
            ) {
                val body = response.body()
                if (body != null && response.isSuccessful) {
                    onSuccess(body)
                } else {
                    onFailure(HttpException(response))
                }
            }

            override fun onFailure(call: Call<GithubUserInfo>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}