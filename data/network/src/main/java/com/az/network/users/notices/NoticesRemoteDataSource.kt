package com.az.network.users.notices

import com.az.core.Resource
import com.az.model.users.notices.NoticesData

interface NoticesRemoteDataSource {
    suspend fun getNotices(userId: Int, currentPage: Int, size: Int): Resource<NoticesData>
}