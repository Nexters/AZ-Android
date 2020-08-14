package com.az.model.users.bookmark.create

import com.az.core.Resource

interface CreateBookmarkRepository {
    suspend fun addBookmark(postId: Int): Resource<CreateBookmarkResponseData>
}