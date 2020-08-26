package com.az.model.users.notices.delete

import com.az.core.Resource

interface DeleteNoticeRepository {
    suspend fun deleteNotice(userId: Int, noticeId: Int): Resource<DeleteNoticeResponseData>
}