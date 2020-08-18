package com.az.repository.users.nickname

import com.az.model.users.nickname.NicknameRepository
import org.koin.dsl.module

val nicknameRepositoryModule = module {
    single<NicknameRepository> { NicknameRepositoryImpl(get()) }
}