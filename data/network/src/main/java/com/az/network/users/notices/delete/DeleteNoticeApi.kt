package com.az.network.users.notices.delete

import com.az.model.users.notices.delete.DeleteNoticeResponseData
import retrofit2.http.DELETE
import retrofit2.http.Path

interface DeleteNoticeApi {
    @DELETE("/v1/api/users/{userId}/notices/{noticeId}")
    suspend fun deleteNotice(
        @Path("userId") userId: Int,
        @Path("noticeId") noticeId: Int
    ): DeleteNoticeResponseData
}