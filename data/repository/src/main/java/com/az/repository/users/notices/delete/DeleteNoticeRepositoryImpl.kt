package com.az.repository.users.notices.delete

import com.az.core.Resource
import com.az.model.users.notices.delete.DeleteNoticeRepository
import com.az.model.users.notices.delete.DeleteNoticeResponseData
import com.az.network.users.notices.delete.DeleteNoticeRemoteDataSource

class DeleteNoticeRepositoryImpl(
    private val deleteNoticeRemoteDataSource: DeleteNoticeRemoteDataSource
) : DeleteNoticeRepository {
    override suspend fun deleteNotice(
        userId: Int,
        noticeId: Int
    ): Resource<DeleteNoticeResponseData> {
        return deleteNoticeRemoteDataSource.deleteNotice(userId, noticeId)
    }
}