package com.olaf.network.auth

import org.koin.dsl.module

val apiModule = module {
    single<AuthRemoteDataSource> { AuthRemoteDataSourceImpl(get()) }
}