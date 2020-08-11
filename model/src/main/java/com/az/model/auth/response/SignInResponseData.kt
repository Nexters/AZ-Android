package com.az.model.auth.response

import com.az.model.token.AccessTokenData
import com.olaf.model.user.SimpleUser

data class SignInResponseData(
    val user: SimpleUser,
    val accessToken: AccessTokenData,
    val refreshToken: String
)