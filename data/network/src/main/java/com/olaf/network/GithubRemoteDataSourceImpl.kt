package com.olaf.network

import com.olaf.model.post.GithubUserInfoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class GithubRemoteDataSourceImpl(
    private val githubApi: GithubApi
) : GithubRemoteDataSource {
    override fun getUserInfo(
        name: String,
        onSuccess: (response: GithubUserInfoData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        githubApi.getUserInfo(name).enqueue(object : Callback<GithubUserInfoData> {
            override fun onResponse(
                call: Call<GithubUserInfoData>,
                response: Response<GithubUserInfoData>
            ) {
                val body = response.body()
                if (body != null && response.isSuccessful) {
                    onSuccess(body)
                } else {
                    onFailure(HttpException(response))
                }
            }

            override fun onFailure(call: Call<GithubUserInfoData>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}