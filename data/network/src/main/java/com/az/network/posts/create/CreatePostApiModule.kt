package com.az.network.posts.create

import org.koin.dsl.module
import retrofit2.Retrofit

val createPostApiModule = module {
    factory<CreatePostRemoteDataSource> { CreatePostRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            CreatePostApi::class.java
        )
    }
}