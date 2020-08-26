package com.az.repository.users.notices.delete

import com.az.model.users.notices.delete.DeleteNoticeRepository
import org.koin.dsl.module

val deleteNoticeRepositoryModule = module {
    single<DeleteNoticeRepository> { DeleteNoticeRepositoryImpl(get()) }
}