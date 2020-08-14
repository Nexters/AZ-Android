package com.az.network.users.rating

import com.az.core.Resource
import com.az.model.users.rating.UserRatingData
import com.az.network.responsehandler.ResponseHandler

class UserRatingRemoteDataSourceImpl(
    private val userRatingApi: UserRatingApi,
    private val responseHandler: ResponseHandler
) : UserRatingRemoteDataSource {
    override suspend fun getUserRating(userId: Int): Resource<UserRatingData> {
        return try {
            userRatingApi.getPosts(userId).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}