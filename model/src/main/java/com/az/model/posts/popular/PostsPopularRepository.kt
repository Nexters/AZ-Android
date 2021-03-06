package com.az.model.posts.popular

import com.az.core.Resource
import com.az.model.posts.PostsData


interface PostsPopularRepository {
    suspend fun getPopularPosts(currentPage: Int, size: Int): Resource<PostsData>
}