package com.az.model.users.posts

import com.az.core.Resource
import com.az.model.posts.PostsData

interface UserPostsRepository {
    suspend fun getPosts(userId: Int, currentPage: Int, size: Int): Resource<PostsData>
}