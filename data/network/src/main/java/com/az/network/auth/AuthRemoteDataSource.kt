package com.az.network.auth

import com.az.core.Resource
import com.az.core.data.auth.request.SignUpRequestData
import com.az.core.data.auth.response.SignInResponseData

interface AuthRemoteDataSource {

    suspend fun signUp(
        signUpRequestData: SignUpRequestData
    ): Resource<SignInResponseData>
}