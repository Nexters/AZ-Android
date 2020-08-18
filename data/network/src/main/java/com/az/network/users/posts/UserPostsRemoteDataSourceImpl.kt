package com.az.network.users.posts

import com.az.core.Resource
import com.az.model.posts.PostsData
import com.az.network.responsehandler.ResponseHandler
import java.lang.Exception

class UserPostsRemoteDataSourceImpl(
    private val userPostsApi: UserPostsApi,
    private val responseHandler: ResponseHandler
) : UserPostsRemoteDataSource {
    override suspend fun getPosts(userId: Int, currentPage: Int, size: Int): Resource<PostsData> {
        return try {
            userPostsApi.getPosts(userId, currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}