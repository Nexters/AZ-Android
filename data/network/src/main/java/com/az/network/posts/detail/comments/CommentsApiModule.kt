package com.az.network.posts.detail.comments

import org.koin.dsl.module
import retrofit2.Retrofit

val commentsApiModule = module {
    factory<CommentsRemoteDataSource> { CommentsRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            CommentsApi::class.java
        )
    }
}