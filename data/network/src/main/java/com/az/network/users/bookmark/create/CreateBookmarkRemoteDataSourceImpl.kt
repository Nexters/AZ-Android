package com.az.network.users.bookmark.create

import com.az.core.Resource
import com.az.model.users.bookmark.create.CreateBookmarkResponseData
import com.az.network.responsehandler.ResponseHandler

class CreateBookmarkRemoteDataSourceImpl(
    private val createBookmarkApi: CreateBookmarkApi,
    private val responseHandler: ResponseHandler
) : CreateBookmarkRemoteDataSource {
    override suspend fun addBookmark(postId: Int): Resource<CreateBookmarkResponseData> {
        return try {
            createBookmarkApi.addBookmark(postId).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}