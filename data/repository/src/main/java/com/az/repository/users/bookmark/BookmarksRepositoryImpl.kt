package com.az.repository.users.bookmark

import com.az.core.Resource
import com.az.model.users.bookmark.BookmarksData
import com.az.model.users.bookmark.BookmarksRepository
import com.az.network.users.bookmark.BookmarksRemoteDataSource

class BookmarksRepositoryImpl(
    private val bookmarksRemoteDataSource: BookmarksRemoteDataSource
) : BookmarksRepository {
    override suspend fun getBookmarks(
        userId: Int,
        currentPage: Int,
        size: Int
    ): Resource<BookmarksData> {
        return bookmarksRemoteDataSource.getBookmarks(userId, currentPage, size)
    }
}