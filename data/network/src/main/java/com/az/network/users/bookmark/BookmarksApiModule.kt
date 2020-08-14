package com.az.network.users.bookmark

import org.koin.dsl.module
import retrofit2.Retrofit

val bookmarksApiModule = module {
    factory<BookmarksRemoteDataSource> { BookmarksRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            BookmarksApi::class.java
        )
    }
}