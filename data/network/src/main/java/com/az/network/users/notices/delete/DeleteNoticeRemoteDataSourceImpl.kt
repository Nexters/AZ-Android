package com.az.network.users.notices.delete

import com.az.core.Resource
import com.az.model.users.notices.delete.DeleteNoticeResponseData
import com.az.network.responsehandler.ResponseHandler

class DeleteNoticeRemoteDataSourceImpl(
    private val deleteNoticeApi: DeleteNoticeApi,
    private val responseHandler: ResponseHandler
) : DeleteNoticeRemoteDataSource {
    override suspend fun deleteNotice(
        userId: Int,
        noticeId: Int
    ): Resource<DeleteNoticeResponseData> {
        return try {
            deleteNoticeApi.deleteNotice(userId, noticeId).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}