package com.az.network.posts.create

import com.az.core.Resource
import com.az.model.posts.create.CreatePostRequestData
import com.az.model.posts.create.CreatePostResponseData
import com.az.network.responsehandler.ResponseHandler

class CreatePostRemoteDataSourceImpl(
    private val createPostApi: CreatePostApi,
    private val responseHandler: ResponseHandler
) : CreatePostRemoteDataSource {
    override suspend fun createPost(post: CreatePostRequestData): Resource<CreatePostResponseData> {
        return try {
            createPostApi.createPost(post).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}