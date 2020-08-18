package com.az.network.users.identification

import org.koin.dsl.module
import retrofit2.Retrofit

val identificationApiModule = module {
    factory<IdentificationRemoteDataSource> { IdentificationRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            IdentificationApi::class.java
        )
    }
}