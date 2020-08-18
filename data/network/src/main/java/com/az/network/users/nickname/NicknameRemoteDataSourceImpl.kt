package com.az.network.users.nickname

import com.az.core.Resource
import com.az.model.users.nickname.NicknameResponseData
import com.az.network.responsehandler.ResponseHandler

class NicknameRemoteDataSourceImpl(
    private val nicknameApi: NicknameApi,
    private val responseHandler: ResponseHandler
) : NicknameRemoteDataSource {
    override suspend fun isNicknameExist(nickname: String): Resource<NicknameResponseData> {
        return try {
            nicknameApi.isNicknameExist(nickname).let { response ->
                responseHandler.handleSuccess(
                    NicknameResponseData(response.code(), response.message())
                )
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}