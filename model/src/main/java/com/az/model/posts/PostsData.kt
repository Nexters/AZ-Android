package com.az.model.posts

data class PostsData(
    val posts: List<PostData>,
    val simplePage: SimplePageData
)

data class PostData(
    val author: Author,
    val bookMarks: Int,
    val comments: Int,
    val content: String,
    val createdDate: String,
    val id: Int,
    val likes: Int,
    val modifiedDate: String,
    val pressLike: Boolean
)

data class Author(
    val id: Int,
    val identification: String,
    val nickname: String,
    val rating: String
)

data class SimplePageData(
    val currentPage: Int,
    val totalElements: Int,
    val totalPages: Int
)