package com.az.model.users.nickname

import com.az.core.Resource

interface NicknameRepository {
    suspend fun isNicknameExist(nickname: String): Resource<NicknameResponseData>
}