package com.olaf.model.auth.response

import com.olaf.model.token.AccessTokenData

data class RefreshAccessTokenResponseData(
    val accessToken: AccessTokenData
)