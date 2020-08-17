package com.az.repository.posts.create

import com.az.model.posts.create.CreatePostRepository
import org.koin.dsl.module

val createPostRepositoryModule = module {
    single<CreatePostRepository> { CreatePostRepositoryImpl(get()) }
}