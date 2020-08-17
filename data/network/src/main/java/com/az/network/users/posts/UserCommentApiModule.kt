package com.az.network.users.posts

import org.koin.dsl.module
import retrofit2.Retrofit

val userPostsApiModule = module {
    factory<UserPostsRemoteDataSource> { UserPostsRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            UserPostsApi::class.java
        )
    }
}