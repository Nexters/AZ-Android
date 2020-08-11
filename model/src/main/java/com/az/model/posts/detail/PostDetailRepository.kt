package com.az.model.posts.detail

import com.az.model.Resource

interface PostDetailRepository {
    suspend fun getPostDetail(postId: Int): Resource<PostDetailData>
}