package com.az.network.users.identification

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface IdentificationApi {
    @POST("/v1/api/users/identifications/{identification}/existence")
    suspend fun isIdentificationExist(
        @Path("identification") identification: String
    ): Response<ResponseBody>
}
