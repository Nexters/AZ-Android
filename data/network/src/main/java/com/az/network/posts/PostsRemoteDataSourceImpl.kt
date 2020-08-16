package com.az.network.posts

import com.az.core.Resource
import com.az.model.posts.PostsData
import com.az.network.responsehandler.ResponseHandler

class PostsRemoteDataSourceImpl(
    private val postsApi: PostsApi,
    private val responseHandler: ResponseHandler
) : PostsRemoteDataSource {
    override suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData> {
        return try {
            postsApi.getPosts(currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}