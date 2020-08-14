package com.az.repository.posts

import com.az.core.Resource
import com.az.model.posts.PostsData
import com.az.model.posts.PostsRepository
import com.az.network.posts.PostsRemoteDataSource

class PostsRepositoryImpl(
    private val postsRemoteDataSource: PostsRemoteDataSource
) : PostsRepository {
    override suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData> {
        return postsRemoteDataSource.getPosts(currentPage, size)
    }
}