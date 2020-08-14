package com.az.repository.users.bookmark.create

import com.az.model.users.bookmark.create.CreateBookmarkRepository
import org.koin.dsl.module

val createBookmarkRepositoryModule = module {
    single<CreateBookmarkRepository> { CreateBookmarkRepositoryImpl(get()) }
}