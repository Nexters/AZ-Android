package com.az.repository.users.posts

import com.az.model.users.posts.UserPostsRepository
import org.koin.dsl.module

val userPostsRepositoryModule = module {
    single<UserPostsRepository> {
        UserPostsRepositoryImpl(get())
    }
}