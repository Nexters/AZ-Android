package com.az.model.auth

import com.az.model.auth.request.SignUpRequestData
import com.az.model.auth.response.SignInResponseData

interface AuthRepository {

    fun signUp(
        signUpRqData: SignUpRequestData,
        onSuccess: (response: SignInResponseData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}