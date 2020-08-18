package com.az.network.users.posts

import com.az.core.Resource
import com.az.model.posts.PostsData

interface UserPostsRemoteDataSource {
    suspend fun getPosts(userId: Int, currentPage: Int, size: Int): Resource<PostsData>
}