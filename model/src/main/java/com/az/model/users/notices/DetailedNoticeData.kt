package com.az.model.users.notices

import com.az.model.posts.detail.DetailedPostData

data class DetailedNoticeData(
    val createdDate: String,
    val detailedPost: DetailedPostData,
    val message: String,
    val noticeId: Int,
    val noticeType: String
)