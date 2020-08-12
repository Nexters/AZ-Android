package com.az.model.posts.detail

import com.az.core.Resource


interface PostDetailRepository {
    suspend fun getPostDetail(postId: Int): Resource<PostDetailData>
}