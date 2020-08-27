package com.az.network.users.notices

import com.az.core.Resource
import com.az.model.users.notices.NoticesData
import com.az.network.responsehandler.ResponseHandler

class NoticesRemoteDataSourceImpl(
    private val noticesApi: NoticesApi,
    private val responseHandler: ResponseHandler
) : NoticesRemoteDataSource {
    override suspend fun getNotices(
        userId: Int,
        currentPage: Int,
        size: Int
    ): Resource<NoticesData> {
        return try {
            noticesApi.getNotices(userId, currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}