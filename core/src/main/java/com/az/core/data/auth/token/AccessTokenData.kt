package com.az.core.data.auth.token

data class AccessTokenData (
    val token: String,
    val expire: Long
)