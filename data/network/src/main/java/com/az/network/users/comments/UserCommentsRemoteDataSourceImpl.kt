package com.az.network.users.comments

import com.az.core.Resource
import com.az.model.posts.detail.comments.CommentsData
import com.az.network.posts.detail.comments.CommentsRemoteDataSource
import com.az.network.responsehandler.ResponseHandler

class UserCommentsRemoteDataSourceImpl(
    private val commentsApi: UserCommentsApi,
    private val responseHandler: ResponseHandler
) : UserCommentsRemoteDataSource {
    override suspend fun getComments(
        userId: Int,
        currentPage: Int,
        size: Int
    ): Resource<CommentsData> {
        return try {
            commentsApi.getComments(userId, currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}