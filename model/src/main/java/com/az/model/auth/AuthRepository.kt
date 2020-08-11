package com.az.model.auth

import com.az.core.Resource
import com.az.core.data.auth.request.SignInRequestData
import com.az.core.data.auth.request.SignUpRequestData
import com.az.core.data.auth.response.SignInResponseData

interface AuthRepository {

    suspend fun signUp(
        signUpRqData: SignUpRequestData
    ): Resource<SignInResponseData>

    suspend fun login(
        signInRqData: SignInRequestData
    ): Resource<SignInResponseData>
}