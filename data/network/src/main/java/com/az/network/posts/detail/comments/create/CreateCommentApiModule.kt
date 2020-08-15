package com.az.network.posts.detail.comments.create

import org.koin.dsl.module
import retrofit2.Retrofit

val createCommentApiModule = module {
    factory<CreateCommentRemoteDataSource> { CreateCommentRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            CreateCommentApi::class.java
        )
    }
}