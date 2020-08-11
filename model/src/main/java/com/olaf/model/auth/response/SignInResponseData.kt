package com.olaf.model.auth.response

import com.olaf.model.token.AccessTokenData
import com.olaf.model.user.SimpleUser

data class SignInResponseData(
    val user: SimpleUser,
    val accessToken: AccessTokenData,
    val refreshToken: String
)