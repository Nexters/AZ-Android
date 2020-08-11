package com.olaf.network.auth

import com.olaf.model.auth.request.SignUpRequestData
import com.olaf.model.auth.response.SignInResponseData

interface AuthRemoteDataSource {

    fun signUp(
        signUpRequestData: SignUpRequestData,
        onSuccess: (response: SignInResponseData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}