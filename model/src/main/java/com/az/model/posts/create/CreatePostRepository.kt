package com.az.model.posts.create

import com.az.core.Resource

interface CreatePostRepository {
    suspend fun createPost(
        post: CreatePostRequestData
    ): Resource<CreatePostResponseData>
}