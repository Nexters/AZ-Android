package com.az.network.posts.detail.comments.create

import com.az.core.Resource
import com.az.model.posts.detail.comments.create.CreateCommentRequestData
import com.az.model.posts.detail.comments.create.CreateCommentResponseData

interface CreateCommentRemoteDataSource {
    suspend fun createComment(
        postId: Int,
        comment: CreateCommentRequestData
    ): Resource<CreateCommentResponseData>
}