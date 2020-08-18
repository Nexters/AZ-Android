package com.az.model.posts.detail.comments

import com.az.model.BaseDataInterface

data class CommentData(
    val content: String,
    val createdDate: String,
    val id: Int,
    val modifiedDate: String,
    val postId: Int,
    val writer: WriterData
): BaseDataInterface