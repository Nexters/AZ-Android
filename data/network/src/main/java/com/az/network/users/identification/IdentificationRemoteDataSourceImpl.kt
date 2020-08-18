package com.az.network.users.identification

import com.az.core.Resource
import com.az.model.users.identification.IdentificationResponseData
import com.az.network.responsehandler.ResponseHandler

class IdentificationRemoteDataSourceImpl(
    private val identificationApi: IdentificationApi,
    private val responseHandler: ResponseHandler
) : IdentificationRemoteDataSource {
    override suspend fun isIdentificationExist(identification: String): Resource<IdentificationResponseData> {
        return try {
            identificationApi.isIdentificationExist(identification).let { response ->
                responseHandler.handleSuccess(
                    IdentificationResponseData(response.code(), response.message())
                )
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}