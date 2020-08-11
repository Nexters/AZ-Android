package com.az.network.posts

import com.az.model.posts.PostsData
import com.az.model.Resource

interface PostsRemoteDataSource {
    suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData>
}