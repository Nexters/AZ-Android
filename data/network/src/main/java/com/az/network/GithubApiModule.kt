package com.olaf.network

import org.koin.dsl.module

val githubApiModule = module {
    single<GithubRemoteDataSource> { GithubRemoteDataSourceImpl(get()) }
}