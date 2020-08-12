package com.az.model.posts

import com.az.core.Resource


interface PostsRepository {
    suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData>
}