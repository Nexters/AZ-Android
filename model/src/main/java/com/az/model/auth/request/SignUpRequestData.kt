package com.az.model.auth.request

data class SignUpRequestData(
    val identification: String,
    val password: String,
    val nickname: String
)