package com.az.repository.users.notices

import com.az.core.Resource
import com.az.model.users.notices.NoticesData
import com.az.model.users.notices.NoticesRepository
import com.az.network.users.notices.NoticesRemoteDataSource

class NoticesRepositoryImpl(
    private val noticesRemoteDataSource: NoticesRemoteDataSource
) : NoticesRepository {
    override suspend fun getNotices(
        userId: Int,
        currentPage: Int,
        size: Int
    ): Resource<NoticesData> {
        return noticesRemoteDataSource.getNotices(userId, currentPage, size)
    }
}