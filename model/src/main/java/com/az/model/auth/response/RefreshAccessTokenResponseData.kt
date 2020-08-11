package com.az.model.auth.response

import com.az.model.token.AccessTokenData

data class RefreshAccessTokenResponseData(
    val accessToken: AccessTokenData
)