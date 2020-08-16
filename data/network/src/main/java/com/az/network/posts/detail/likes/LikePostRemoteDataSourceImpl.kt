package com.az.network.posts.detail.likes

import com.az.core.Resource
import com.az.model.posts.detail.likes.LikePostResponseData
import com.az.network.responsehandler.ResponseHandler

class LikePostRemoteDataSourceImpl(
    private val likePostApi: LikePostApi,
    private val responseHandler: ResponseHandler
) : LikePostRemoteDataSource {
    override suspend fun likePost(postId: Int): Resource<LikePostResponseData> {
        return try {
            likePostApi.likePost(postId).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}