package com.az.repository.users.notices

import com.az.model.users.notices.NoticesRepository
import org.koin.dsl.module

val noticesRepositoryModule = module {
    single<NoticesRepository> { NoticesRepositoryImpl(get()) }
}