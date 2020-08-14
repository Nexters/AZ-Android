package com.az.model.posts.detail.comments

data class CommentData(
    val content: String,
    val createdDate: String,
    val id: Int,
    val modifiedDate: String,
    val postId: Int,
    val writer: WriterData
)