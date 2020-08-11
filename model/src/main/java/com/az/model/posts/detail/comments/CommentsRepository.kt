package com.az.model.posts.detail.comments

import com.az.model.Resource

interface CommentsRepository {
    suspend fun getComments(postId: Int, currentPage: Int, size: Int): Resource<CommentsData>
}