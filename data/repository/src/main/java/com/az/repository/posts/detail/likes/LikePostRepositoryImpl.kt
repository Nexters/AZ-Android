package com.az.repository.posts.detail.likes

import com.az.core.Resource
import com.az.model.posts.detail.likes.LikePostRepository
import com.az.model.posts.detail.likes.LikePostResponseData
import com.az.network.posts.detail.likes.LikePostRemoteDataSource

class LikePostRepositoryImpl(
    private val likePostRemoteDataSource: LikePostRemoteDataSource
) : LikePostRepository {
    override suspend fun likePost(postId: Int): Resource<LikePostResponseData> {
        return likePostRemoteDataSource.likePost(postId)
    }
}