package com.az.core.data.auth.request

data class SignInRequestData(
    val identification: String,
    val password: String
)