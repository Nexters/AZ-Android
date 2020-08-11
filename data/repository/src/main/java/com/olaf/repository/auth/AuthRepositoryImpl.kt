package com.olaf.repository.auth

import com.olaf.model.auth.AuthRepository
import com.olaf.model.auth.request.SignUpRequestData
import com.olaf.model.auth.response.SignInResponseData
import com.olaf.network.auth.AuthRemoteDataSource

class AuthRepositoryImpl(
    private val api: AuthRemoteDataSource
) : AuthRepository {

    override fun signUp(
        signUpRqData: SignUpRequestData,
        onSuccess: (response: SignInResponseData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        api.signUp(signUpRqData, onSuccess, onFailure)
    }

}