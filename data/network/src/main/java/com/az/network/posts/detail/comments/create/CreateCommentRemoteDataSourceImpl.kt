package com.az.network.posts.detail.comments.create

import com.az.core.Resource
import com.az.model.posts.detail.comments.create.CreateCommentRequestData
import com.az.model.posts.detail.comments.create.CreateCommentResponseData
import com.az.network.responsehandler.ResponseHandler

class CreateCommentRemoteDataSourceImpl(
    private val createCommentApi: CreateCommentApi,
    private val responseHandler: ResponseHandler
) : CreateCommentRemoteDataSource {
    override suspend fun createComment(
        postId: Int,
        comment: CreateCommentRequestData
    ): Resource<CreateCommentResponseData> {
        return try {
            createCommentApi.createComment(postId, comment).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}