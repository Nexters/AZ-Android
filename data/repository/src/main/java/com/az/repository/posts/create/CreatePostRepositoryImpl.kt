package com.az.repository.posts.create

import com.az.core.Resource
import com.az.model.posts.create.CreatePostRepository
import com.az.model.posts.create.CreatePostRequestData
import com.az.model.posts.create.CreatePostResponseData
import com.az.network.posts.create.CreatePostRemoteDataSource

class CreatePostRepositoryImpl(
    private val createPostRemoteDataSource: CreatePostRemoteDataSource
) : CreatePostRepository {
    override suspend fun createPost(post: CreatePostRequestData): Resource<CreatePostResponseData> {
        return createPostRemoteDataSource.createPost(post)
    }
}