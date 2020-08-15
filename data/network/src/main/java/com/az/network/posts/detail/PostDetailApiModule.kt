package com.az.network.posts.detail

import org.koin.dsl.module
import retrofit2.Retrofit

val postDetailApiModule = module {
    factory<PostDetailRemoteDataSource> { PostDetailRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            PostDetailApi::class.java
        )
    }
}