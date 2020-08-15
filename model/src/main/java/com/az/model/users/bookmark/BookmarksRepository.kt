package com.az.model.users.bookmark

import com.az.core.Resource

interface BookmarksRepository {
    suspend fun getBookmarks(userId: Int, currentPage: Int, size: Int): Resource<BookmarksData>
}