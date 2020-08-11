package com.az.network.posts.detail.comments

import com.az.model.Resource
import com.az.model.posts.detail.comments.CommentsData

interface CommentsRemoteDataSource {
    suspend fun getComments(postId: Int, currentPage: Int, size: Int): Resource<CommentsData>
}