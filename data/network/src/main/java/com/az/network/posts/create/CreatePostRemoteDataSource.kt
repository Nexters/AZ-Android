package com.az.network.posts.create

import com.az.core.Resource
import com.az.model.posts.create.CreatePostRequestData
import com.az.model.posts.create.CreatePostResponseData

interface CreatePostRemoteDataSource {
    suspend fun createPost(
        post: CreatePostRequestData
    ): Resource<CreatePostResponseData>
}