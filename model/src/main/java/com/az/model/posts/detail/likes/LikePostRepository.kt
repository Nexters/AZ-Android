package com.az.model.posts.detail.likes

import com.az.core.Resource

interface LikePostRepository {
    suspend fun likePost(postId: Int): Resource<LikePostResponseData>
}