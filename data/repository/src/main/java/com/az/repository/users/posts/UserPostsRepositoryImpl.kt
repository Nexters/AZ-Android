package com.az.repository.users.posts

import com.az.core.Resource
import com.az.model.posts.PostsData
import com.az.model.users.posts.UserPostsRepository
import com.az.network.users.posts.UserPostsRemoteDataSource

class UserPostsRepositoryImpl(
    private val userPostsRemoteDataSource: UserPostsRemoteDataSource
) : UserPostsRepository {
    override suspend fun getPosts(userId: Int, currentPage: Int, size: Int): Resource<PostsData> {
        return userPostsRemoteDataSource.getPosts(userId, currentPage, size)
    }
}