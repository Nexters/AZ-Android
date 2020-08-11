package com.az.repository.auth

import com.az.core.Resource
import com.az.core.data.auth.request.SignInRequestData
import com.az.core.data.auth.request.SignUpRequestData
import com.az.core.data.auth.response.SignInResponseData
import com.az.model.auth.AuthRepository
import com.az.network.auth.AuthRemoteDataSource

class AuthRepositoryImpl(
    private val api: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun signUp(signUpRqData: SignUpRequestData): Resource<SignInResponseData> {
        return api.signUp(signUpRqData)
    }

    override suspend fun login(signInRqData: SignInRequestData): Resource<SignInResponseData> {
        return api.login(signInRqData)
    }
}