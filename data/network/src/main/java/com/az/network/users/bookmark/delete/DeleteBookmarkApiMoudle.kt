package com.az.network.users.bookmark.delete

import org.koin.dsl.module
import retrofit2.Retrofit

val deleteBookmarkApiModule = module {
    factory<DeleteBookmarkRemoteDataSource> { DeleteBookmarkRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            DeleteBookmarkApi::class.java
        )
    }
}