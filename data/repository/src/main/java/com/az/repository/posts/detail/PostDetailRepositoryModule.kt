package com.az.repository.posts.detail

import com.az.model.posts.detail.PostDetailRepository
import org.koin.dsl.module

val postDetailRepositoryModule = module {
    single<PostDetailRepository> { PostDetailRepositoryImpl(get()) }
}