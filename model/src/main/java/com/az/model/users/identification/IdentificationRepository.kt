package com.az.model.users.identification

import com.az.core.Resource

interface IdentificationRepository {
    suspend fun isIdentificationExist(identification: String): Resource<IdentificationResponseData>
}