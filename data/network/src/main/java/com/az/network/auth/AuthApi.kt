package com.az.network.auth
import com.az.core.data.auth.request.SignInRequestData
import com.az.core.data.auth.request.SignUpRequestData
import com.az.core.data.auth.response.SignInResponseData
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {

    @POST("v1/api/auth/sign-up")
    suspend fun signUp(
        @Body
        signUpRequestData: SignUpRequestData
    ): SignInResponseData

    @POST("v1/api/auth/sign-in")
    suspend fun login(
        @Body
        signInRequestData: SignInRequestData
    ): SignInResponseData
}