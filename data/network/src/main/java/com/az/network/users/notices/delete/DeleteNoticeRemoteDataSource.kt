package com.az.network.users.notices.delete

import com.az.core.Resource
import com.az.model.users.notices.delete.DeleteNoticeResponseData

interface DeleteNoticeRemoteDataSource {
    suspend fun deleteNotice(userId: Int, noticeId: Int): Resource<DeleteNoticeResponseData>
}