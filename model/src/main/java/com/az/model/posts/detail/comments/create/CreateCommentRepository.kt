package com.az.model.posts.detail.comments.create

import com.az.core.Resource

interface CreateCommentRepository {
    suspend fun createComment(
        postId: Int,
        comment: CreateCommentRequestData
    ): Resource<CreateCommentResponseData>
}