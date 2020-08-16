package com.az.network.posts.detail.likes

import com.az.core.Resource
import com.az.model.posts.detail.likes.LikePostResponseData

interface LikePostRemoteDataSource {
    suspend fun likePost(postId: Int): Resource<LikePostResponseData>
}