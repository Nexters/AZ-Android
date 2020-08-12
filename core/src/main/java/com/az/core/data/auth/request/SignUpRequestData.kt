package com.az.core.data.auth.request

data class SignUpRequestData(
    val identification: String,
    val password: String,
    val nickname: String
)