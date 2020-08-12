package com.az.network.auth

import com.az.core.Resource
import com.az.core.data.auth.request.SignInRequestData
import com.az.core.data.auth.request.SignUpRequestData
import com.az.core.data.auth.response.SignInResponseData
import com.az.network.ResponseHandler
import retrofit2.HttpException

class AuthRemoteDataSourceImpl(
    private val authApi: AuthApi,
    private val responseHandler: ResponseHandler
) : AuthRemoteDataSource {

    override suspend fun signUp(
        signUpRequestData: SignUpRequestData
    ): Resource<SignInResponseData> {
        return try {
            val response = authApi.signUp(signUpRequestData)
            responseHandler.handleSuccess(response)
        } catch (e: HttpException) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun login(signInRequestData: SignInRequestData): Resource<SignInResponseData> {
        return try {
            val response = authApi.login(signInRequestData)
            responseHandler.handleSuccess(response)
        } catch (e: HttpException) {
            responseHandler.handleException(e)
        }
    }
}