package com.az.repository.posts.detail.comments

import com.az.model.posts.detail.comments.CommentsRepository
import org.koin.dsl.module

val commentsRepositoryModule = module {
    single<CommentsRepository> { CommentsRepositoryImpl(get()) }
}