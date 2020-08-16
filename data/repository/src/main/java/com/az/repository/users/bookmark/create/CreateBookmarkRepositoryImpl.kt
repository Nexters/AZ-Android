package com.az.repository.users.bookmark.create

import com.az.core.Resource
import com.az.model.users.bookmark.create.CreateBookmarkRepository
import com.az.model.users.bookmark.create.CreateBookmarkResponseData
import com.az.network.users.bookmark.create.CreateBookmarkRemoteDataSource

class CreateBookmarkRepositoryImpl(
    private val createBookmarkRemoteDataSource: CreateBookmarkRemoteDataSource
) : CreateBookmarkRepository {
    override suspend fun addBookmark(postId: Int): Resource<CreateBookmarkResponseData> {
        return createBookmarkRemoteDataSource.addBookmark(postId)
    }
}