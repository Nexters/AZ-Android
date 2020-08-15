package com.az.network.users.bookmark

import com.az.core.Resource
import com.az.model.users.bookmark.BookmarksData

interface BookmarksRemoteDataSource {
    suspend fun getBookmarks(userId: Int, currentPage: Int, size: Int): Resource<BookmarksData>
}