package com.az.repository.users.bookmark.delete

import com.az.core.Resource
import com.az.model.users.bookmark.delete.DeleteBookmarkRepository
import com.az.model.users.bookmark.delete.DeleteBookmarkResponseData
import com.az.network.users.bookmark.delete.DeleteBookmarkRemoteDataSource

class DeleteBookmarkRepositoryImpl(
    private val deleteBookmarkRemoteDataSource: DeleteBookmarkRemoteDataSource
) : DeleteBookmarkRepository {
    override suspend fun deleteBookmark(postId: Int): Resource<DeleteBookmarkResponseData> {
        return deleteBookmarkRemoteDataSource.deleteBookmark(postId)
    }
}