package com.az.model.auth.request

data class SignInRequestData(
    val identification: String,
    val password: String
)