package com.az.network.users.nickname

import com.az.core.Resource
import com.az.model.users.nickname.NicknameResponseData

interface NicknameRemoteDataSource {
    suspend fun isNicknameExist(nickname: String): Resource<NicknameResponseData>
}