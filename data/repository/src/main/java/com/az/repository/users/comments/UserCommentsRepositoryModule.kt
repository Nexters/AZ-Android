package com.az.repository.users.comments

import com.az.model.users.comments.UserCommentsRepository
import org.koin.dsl.module

val userCommentsRepositoryModule = module {
    single<UserCommentsRepository> {
        UserCommentsRepositoryImpl(get())
    }
}