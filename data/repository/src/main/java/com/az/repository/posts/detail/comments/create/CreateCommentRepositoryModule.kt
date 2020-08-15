package com.az.repository.posts.detail.comments.create

import com.az.model.auth.AuthRepository
import com.az.model.posts.detail.comments.create.CreateCommentRepository
import com.az.repository.auth.AuthRepositoryImpl
import org.koin.dsl.module

val createCommentRepositoryModule = module {
    single<CreateCommentRepository> { CreateCommentRepositoryImpl(get()) }
}