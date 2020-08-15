package com.az.network.posts.detail

import com.az.core.Resource
import com.az.model.posts.detail.PostDetailData
import com.az.network.responsehandler.ResponseHandler

class PostDetailRemoteDataSourceImpl(
    private val postDetailApi: PostDetailApi,
    private val responseHandler: ResponseHandler
) : PostDetailRemoteDataSource {
    override suspend fun getPostDetail(postId: Int): Resource<PostDetailData> {
        return try {
            postDetailApi.getPosts(postId).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}