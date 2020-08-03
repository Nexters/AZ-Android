package com.az.detail

data class TempHumorDetailData(
    val content: String,
    val heart: Int,
    val comment: Int,
    val user: String,
    val time: String,
    val isHeart: Boolean,
    val isComment: Boolean
)