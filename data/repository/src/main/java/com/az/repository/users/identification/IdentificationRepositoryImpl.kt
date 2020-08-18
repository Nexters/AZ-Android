package com.az.repository.users.identification

import com.az.core.Resource
import com.az.model.users.identification.IdentificationRepository
import com.az.model.users.identification.IdentificationResponseData
import com.az.network.users.identification.IdentificationRemoteDataSource

class IdentificationRepositoryImpl(
    private val identificationRemoteDataSource: IdentificationRemoteDataSource
): IdentificationRepository {
    override suspend fun isIdentificationExist(identification: String): Resource<IdentificationResponseData> {
        return identificationRemoteDataSource.isIdentificationExist(identification)
    }
}