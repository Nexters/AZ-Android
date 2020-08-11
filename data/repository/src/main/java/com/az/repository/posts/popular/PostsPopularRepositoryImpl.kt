package com.az.repository.posts.popular

import com.az.model.Resource
import com.az.model.posts.PostsData
import com.az.model.posts.PostsRepository
import com.az.model.posts.popular.PostsPopularRepository
import com.az.network.posts.popular.PostsPopularRemoteDataSource
import org.koin.dsl.module

val postsPopularRepositoryModule = module {
    single<PostsPopularRepository> { PostsPopularRepositoryImpl(get()) }
}

class PostsPopularRepositoryImpl(
    private val postsPopularRemoteDataSource: PostsPopularRemoteDataSource
) : PostsPopularRepository {
    override suspend fun getPopularPosts(currentPage: Int, size: Int): Resource<PostsData> {
        return postsPopularRemoteDataSource.getPopularPosts(currentPage, size)
    }
}