package com.olaf.model.auth

import com.olaf.model.auth.request.SignUpRequestData
import com.olaf.model.auth.response.SignInResponseData

interface SignUpRepository {

    fun signUp(
        signUpRqData: SignUpRequestData,
        onSuccess: (response: SignInResponseData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )
}