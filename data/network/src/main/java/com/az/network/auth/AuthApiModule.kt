package com.az.network.auth

import org.koin.dsl.module
import retrofit2.Retrofit

val authApiModule = module {

    factory<AuthRemoteDataSource> { AuthRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            AuthApi::class.java
        )
    }
}