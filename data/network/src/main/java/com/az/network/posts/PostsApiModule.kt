package com.az.network.posts

import org.koin.dsl.module
import retrofit2.Retrofit

val postsApiModule = module {
    factory<PostsRemoteDataSource> { PostsRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            PostsApi::class.java
        )
    }
}