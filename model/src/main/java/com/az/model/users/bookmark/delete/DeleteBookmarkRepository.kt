package com.az.model.users.bookmark.delete

import com.az.core.Resource

interface DeleteBookmarkRepository {
    suspend fun deleteBookmark(postId: Int): Resource<DeleteBookmarkResponseData>
}