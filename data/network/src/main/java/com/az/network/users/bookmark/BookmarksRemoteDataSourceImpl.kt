package com.az.network.users.bookmark

import com.az.core.Resource
import com.az.model.users.bookmark.BookmarksData
import com.az.network.responsehandler.ResponseHandler

class BookmarksRemoteDataSourceImpl(
    private val bookmarksApi: BookmarksApi,
    private val responseHandler: ResponseHandler
) : BookmarksRemoteDataSource {
    override suspend fun getBookmarks(
        userId: Int,
        currentPage: Int,
        size: Int
    ): Resource<BookmarksData> {
        return try {
            bookmarksApi.getBookmarks(userId, currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}