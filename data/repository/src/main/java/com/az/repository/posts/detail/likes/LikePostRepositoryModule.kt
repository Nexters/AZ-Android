package com.az.repository.posts.detail.likes

import com.az.model.posts.detail.likes.LikePostRepository
import org.koin.dsl.module

val likePostRepositoryModule = module {
    single<LikePostRepository> { LikePostRepositoryImpl(get()) }
}