package com.az.network.users.comments

import org.koin.dsl.module
import retrofit2.Retrofit

val userCommentsApiModule = module {
    factory<UserCommentsRemoteDataSource> { UserCommentsRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            UserCommentsApi::class.java
        )
    }
}