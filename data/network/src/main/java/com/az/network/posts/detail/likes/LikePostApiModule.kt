package com.az.network.posts.detail.likes

import org.koin.dsl.module
import retrofit2.Retrofit

val likePostApiModule = module {
    factory<LikePostRemoteDataSource> { LikePostRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            LikePostApi::class.java
        )
    }
}