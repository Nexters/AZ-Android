package com.az.repository.users.bookmark

import com.az.model.users.bookmark.BookmarksRepository
import org.koin.dsl.module

val bookmarksRepositoryModule = module {
    single<BookmarksRepository> { BookmarksRepositoryImpl(get()) }
}