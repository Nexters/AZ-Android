package com.az.network.posts.detail.comments.create

import com.az.model.posts.detail.comments.create.CreateCommentRequestData
import com.az.model.posts.detail.comments.create.CreateCommentResponseData
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CreateCommentApi {
    @POST("/v1/api/posts/{postId}/comments/comment")
    suspend fun createComment(
        @Path("postId") postId: Int,
        @Body request: CreateCommentRequestData
    ): CreateCommentResponseData
}