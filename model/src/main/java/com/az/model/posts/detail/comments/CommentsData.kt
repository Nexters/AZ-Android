package com.az.model.posts.detail.comments

import com.az.model.posts.SimplePageData

data class CommentsData(
    val commentList: List<CommentData>,
    val simplePage: SimplePageData
)