package com.az.model.posts

data class PostData(
    val author: AuthorData,
    val bookMarks: Int,
    val comments: Int,
    val content: String,
    val createdDate: String,
    val id: Int,
    val likes: Int,
    val modifiedDate: String,
    val pressLike: Boolean
)