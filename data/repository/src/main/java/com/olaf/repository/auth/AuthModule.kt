package com.olaf.repository.auth

import com.az.model.auth.AuthRepository
import org.koin.dsl.module

val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}