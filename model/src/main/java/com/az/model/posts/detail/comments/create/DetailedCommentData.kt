package com.az.model.posts.detail.comments.create

import com.az.model.posts.detail.comments.WriterData

data class DetailedCommentData(
    val content: String,
    val createdDate: String,
    val id: Int,
    val modifiedDate: String,
    val postId: Int,
    val writer: WriterData
)