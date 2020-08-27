package com.az.network.users.notices

import org.koin.dsl.module
import retrofit2.Retrofit

val noticesApiModule = module {
    factory<NoticesRemoteDataSource> { NoticesRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            NoticesApi::class.java
        )
    }
}