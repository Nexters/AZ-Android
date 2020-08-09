package com.olaf.model.auth.request

data class SignUpRequestData(
    val identification: String,
    val nickname: String,
    val password: String
)