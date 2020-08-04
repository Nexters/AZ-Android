package com.az.main

data class TempHumorData(
    val user: String,
    val date: String,
    val content: String,
    val heart: Int,
    val comment: Int,
    val isFameHumor: Boolean
)