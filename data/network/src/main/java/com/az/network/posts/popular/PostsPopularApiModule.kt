package com.az.network.posts.popular

import org.koin.dsl.module
import retrofit2.Retrofit

val postsPopularApiModule = module {
    factory<PostsPopularRemoteDataSource> { PostsPopularRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            PostsPopularApi::class.java
        )
    }
}