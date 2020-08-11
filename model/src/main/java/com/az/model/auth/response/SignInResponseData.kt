package com.az.model.auth.response

import com.az.model.token.AccessTokenData

data class SignInResponseData(
    val user: SimpleUserData,
    val accessToken: AccessTokenData,
    val refreshToken: String
)