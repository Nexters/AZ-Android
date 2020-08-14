package com.az.network.users.bookmark.create

import com.az.core.Resource
import com.az.model.users.bookmark.create.CreateBookmarkResponseData

interface CreateBookmarkRemoteDataSource {
    suspend fun addBookmark(postId: Int): Resource<CreateBookmarkResponseData>
}