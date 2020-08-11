package com.olaf.network.auth

import com.az.model.auth.request.SignUpRequestData
import com.az.model.auth.response.SignInResponseData

interface AuthRemoteDataSource {

    fun signUp(
        signUpRequestData: SignUpRequestData,
        onSuccess: (response: SignInResponseData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}