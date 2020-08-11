package com.az.network.users.rating

import com.az.model.Resource
import com.az.model.users.rating.UserRatingData
import com.az.network.responsehandler.ResponseHandler
import org.koin.dsl.module
import retrofit2.Retrofit

val userRatingApiModule = module {
    factory<UserRatingRemoteDataSource> { UserRatingRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            UserRatingApi::class.java
        )
    }
}

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