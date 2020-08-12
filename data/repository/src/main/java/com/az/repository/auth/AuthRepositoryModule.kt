package com.az.repository.auth

import com.az.model.auth.AuthRepository
import org.koin.dsl.module

val authRepositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}