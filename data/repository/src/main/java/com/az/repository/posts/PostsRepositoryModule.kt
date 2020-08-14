package com.az.repository.posts

import com.az.model.posts.PostsRepository
import org.koin.dsl.module

val postsRepositoryModule = module {
    single<PostsRepository> { PostsRepositoryImpl(get()) }
}