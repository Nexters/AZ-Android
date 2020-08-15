package com.az.repository.posts.detail

import com.az.core.Resource
import com.az.model.posts.detail.PostDetailData
import com.az.model.posts.detail.PostDetailRepository
import com.az.network.posts.detail.PostDetailRemoteDataSource

class PostDetailRepositoryImpl(
    private val postDetailRemoteDataSource: PostDetailRemoteDataSource
) : PostDetailRepository {
    override suspend fun getPostDetail(postId: Int): Resource<PostDetailData> {
        return postDetailRemoteDataSource.getPostDetail(postId)
    }
}