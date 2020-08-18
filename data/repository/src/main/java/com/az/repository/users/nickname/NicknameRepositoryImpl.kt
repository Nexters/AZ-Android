package com.az.repository.users.nickname

import com.az.core.Resource
import com.az.model.users.nickname.NicknameRepository
import com.az.model.users.nickname.NicknameResponseData
import com.az.network.users.nickname.NicknameRemoteDataSource

class NicknameRepositoryImpl(
    private val nicknameRemoteDataSource: NicknameRemoteDataSource
) : NicknameRepository {
    override suspend fun isNicknameExist(nickname: String): Resource<NicknameResponseData> {
        return nicknameRemoteDataSource.isNicknameExist(nickname)
    }
}