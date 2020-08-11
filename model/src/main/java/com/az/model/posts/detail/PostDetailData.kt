package com.az.model.posts.detail

data class PostDetailData(
    val detailedPost: DetailedPostData
)

data class DetailedPostData(
    val authorNickname: String,
    val bookMarks: Int,
    val comments: Int,
    val content: String,
    val createdDate: String,
    val id: Int,
    val likes: Int,
    val modifiedDate: String,
    val pressLike: Boolean
)