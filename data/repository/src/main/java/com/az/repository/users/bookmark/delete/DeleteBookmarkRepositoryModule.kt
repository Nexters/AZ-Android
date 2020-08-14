package com.az.repository.users.bookmark.delete

import com.az.model.users.bookmark.delete.DeleteBookmarkRepository
import org.koin.dsl.module

val deleteBookmarkRepositoryModule = module {
    single<DeleteBookmarkRepository> { DeleteBookmarkRepositoryImpl(get()) }
}