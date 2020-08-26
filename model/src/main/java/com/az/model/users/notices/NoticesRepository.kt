package com.az.model.users.notices

import com.az.core.Resource

interface NoticesRepository {
    suspend fun getNotices(userId: Int, currentPage: Int, size: Int): Resource<NoticesData>
}