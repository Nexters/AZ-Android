package com.az.di

import com.az.data.InfoDataSource
import com.az.repository.github.InfoRepository
import com.az.repository.github.InfoRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<InfoRepository> { InfoRepositoryImpl(get() as InfoDataSource) }
}

