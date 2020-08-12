package com.az.core.data.auth.response

import com.az.core.data.auth.token.AccessTokenData

data class RefreshAccessTokenResponseData(
    val accessToken: AccessTokenData
)