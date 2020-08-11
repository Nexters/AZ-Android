package com.az.core.data.auth.response

import com.az.core.data.auth.SimpleUser
import com.az.core.data.auth.token.AccessTokenData


data class SignInResponseData(
    val user: SimpleUser,
    val accessToken: AccessTokenData,
    val refreshToken: String
)