package com.az.repository.posts.popular

import com.az.model.posts.popular.PostsPopularRepository
import org.koin.dsl.module

val postsPopularRepositoryModule = module {
    single<PostsPopularRepository> { PostsPopularRepositoryImpl(get()) }
}