package com.az.network.users.rating

import org.koin.dsl.module
import retrofit2.Retrofit

val userRatingApiModule = module {
    factory<UserRatingRemoteDataSource> { UserRatingRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            UserRatingApi::class.java
        )
    }
}