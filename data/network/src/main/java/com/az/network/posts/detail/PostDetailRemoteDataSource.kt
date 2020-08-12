package com.az.network.posts.detail

import com.az.core.Resource
import com.az.model.posts.detail.PostDetailData

interface PostDetailRemoteDataSource {
    suspend fun getPostDetail(postId: Int): Resource<PostDetailData>
}