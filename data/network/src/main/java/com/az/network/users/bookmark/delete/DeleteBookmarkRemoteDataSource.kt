package com.az.network.users.bookmark.delete

import com.az.core.Resource
import com.az.model.users.bookmark.delete.DeleteBookmarkResponseData

interface DeleteBookmarkRemoteDataSource {
    suspend fun deleteBookmark(postId: Int): Resource<DeleteBookmarkResponseData>
}