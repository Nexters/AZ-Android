package com.az.network.posts.popular

import com.az.model.Resource
import com.az.model.posts.PostsData

interface PostsPopularRemoteDataSource {
    suspend fun getPopularPosts(currentPage: Int, size: Int): Resource<PostsData>
}