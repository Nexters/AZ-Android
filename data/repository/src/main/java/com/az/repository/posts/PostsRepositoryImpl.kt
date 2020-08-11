package com.az.repository.posts

import com.az.model.posts.PostsData
import com.az.model.posts.PostsRepository
import com.az.network.posts.PostsRemoteDataSource
import org.koin.dsl.module

val postsRepositoryModule = module {
    single<PostsRepository> { PostsRepositoryImpl(get()) }
}

class PostsRepositoryImpl(
    private val postsApi: PostsRemoteDataSource
) : PostsRepository {
    override fun getPosts(
        currentPage: Int,
        size: Int,
        onSuccess: (response: PostsData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        postsApi.getPosts(currentPage, size, onSuccess, onFailure)
    }
}