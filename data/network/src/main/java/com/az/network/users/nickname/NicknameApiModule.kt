package com.az.network.users.nickname

import org.koin.dsl.module
import retrofit2.Retrofit

val nicknameApiModule = module {
    factory<NicknameRemoteDataSource> { NicknameRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            NicknameApi::class.java
        )
    }
}