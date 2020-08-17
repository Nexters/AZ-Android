package com.az.network.users.comments

import com.az.core.Resource
import com.az.model.posts.detail.comments.CommentsData

interface UserCommentsRemoteDataSource {
    suspend fun getComments(userId: Int, currentPage: Int, size: Int): Resource<CommentsData>
}