package com.az.repository.users.identification

import com.az.model.users.identification.IdentificationRepository
import org.koin.dsl.module

val identificationRepositoryModule = module {
    single<IdentificationRepository> { IdentificationRepositoryImpl(get()) }
}