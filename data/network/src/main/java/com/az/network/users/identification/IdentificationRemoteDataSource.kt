package com.az.network.users.identification

import com.az.core.Resource
import com.az.model.users.identification.IdentificationResponseData

interface IdentificationRemoteDataSource {
    suspend fun isIdentificationExist(identification: String): Resource<IdentificationResponseData>
}