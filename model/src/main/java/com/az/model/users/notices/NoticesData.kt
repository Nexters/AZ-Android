package com.az.model.users.notices

import com.az.model.posts.SimplePageData

data class NoticesData(
    val detailedNoticeList: List<DetailedNoticeData>,
    val simplePage: SimplePageData
)