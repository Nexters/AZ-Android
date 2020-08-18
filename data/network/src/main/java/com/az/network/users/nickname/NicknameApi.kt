package com.az.network.users.nickname

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface NicknameApi {
    @POST("/v1/api/users/nicknames/{nickname}/existence")
    suspend fun isNicknameExist(
        @Path("nickname") nickname: String
    ): Response<ResponseBody>
}