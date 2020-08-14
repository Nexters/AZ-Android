package com.az.network.users.bookmark.delete

import com.az.core.Resource
import com.az.model.users.bookmark.delete.DeleteBookmarkResponseData
import com.az.network.responsehandler.ResponseHandler

class DeleteBookmarkRemoteDataSourceImpl(
    private val deleteBookmarkApi: DeleteBookmarkApi,
    private val responseHandler: ResponseHandler
) : DeleteBookmarkRemoteDataSource {
    override suspend fun deleteBookmark(postId: Int): Resource<DeleteBookmarkResponseData> {
        return try {
            deleteBookmarkApi.deleteBookmark(postId).let { response ->
                responseHandler.handleSuccess(
                    DeleteBookmarkResponseData(response.code(), response.message())
                )
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}