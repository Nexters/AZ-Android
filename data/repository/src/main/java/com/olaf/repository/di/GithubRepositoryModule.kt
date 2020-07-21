package com.olaf.repository.di

import com.olaf.model.repository.GithubRepository
import com.olaf.repository.GithubRepositoryImpl
import org.koin.dsl.module

val githubRepositoryModule = module {
    single<GithubRepository> { GithubRepositoryImpl(get()) }
}