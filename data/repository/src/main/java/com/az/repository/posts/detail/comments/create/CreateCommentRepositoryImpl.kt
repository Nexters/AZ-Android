package com.az.repository.posts.detail.comments.create

import com.az.core.Resource
import com.az.model.posts.detail.comments.create.CreateCommentRepository
import com.az.model.posts.detail.comments.create.CreateCommentRequestData
import com.az.model.posts.detail.comments.create.CreateCommentResponseData
import com.az.network.posts.detail.comments.create.CreateCommentRemoteDataSource

class CreateCommentRepositoryImpl(
    private val createCommentRemoteDataSource: CreateCommentRemoteDataSource
) : CreateCommentRepository {
    override suspend fun createComment(
        postId: Int,
        comment: CreateCommentRequestData
    ): Resource<CreateCommentResponseData> {
        return createCommentRemoteDataSource.createComment(postId, comment)
    }
}