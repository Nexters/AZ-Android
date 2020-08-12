package com.az.network.posts

import com.az.core.Resource
import com.az.model.posts.PostsData

interface PostsRemoteDataSource {
    suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData>
}