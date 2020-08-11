package com.az.repository.posts

import com.az.model.posts.PostsData
import com.az.model.posts.PostsRepository
import com.az.network.posts.PostsRemoteDataSource
import com.az.model.Resource
import org.koin.dsl.module

val postsRepositoryModule = module {
    single<PostsRepository> { PostsRepositoryImpl(get()) }
}

class PostsRepositoryImpl(
    private val postsRemoteDataSource: PostsRemoteDataSource
) : PostsRepository {
    override suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData> {
        return postsRemoteDataSource.getPosts(currentPage, size)
    }
}