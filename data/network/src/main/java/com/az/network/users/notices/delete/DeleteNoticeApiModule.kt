package com.az.network.users.notices.delete

import org.koin.dsl.module
import retrofit2.Retrofit

val deleteNoticeApiModule = module {
    factory<DeleteNoticeRemoteDataSource> { DeleteNoticeRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            DeleteNoticeApi::class.java
        )
    }
}