package com.az.network.users.bookmark.create

import org.koin.dsl.module
import retrofit2.Retrofit

val createBookmarkApiModule = module {
    factory<CreateBookmarkRemoteDataSource> { CreateBookmarkRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            CreateBookmarkApi::class.java
        )
    }
}