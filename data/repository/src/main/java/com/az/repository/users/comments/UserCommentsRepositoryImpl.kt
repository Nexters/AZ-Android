package com.az.repository.users.comments

import com.az.core.Resource
import com.az.model.posts.detail.comments.CommentsData
import com.az.model.users.comments.UserCommentsRepository
import com.az.network.users.comments.UserCommentsRemoteDataSource

class UserCommentsRepositoryImpl(
    private val userCommentRemoteDataSource: UserCommentsRemoteDataSource
) : UserCommentsRepository {
    override suspend fun getComments(
        userId: Int,
        currentPage: Int,
        size: Int
    ): Resource<CommentsData> {
        return userCommentRemoteDataSource.getComments(userId, currentPage, size)
    }
}