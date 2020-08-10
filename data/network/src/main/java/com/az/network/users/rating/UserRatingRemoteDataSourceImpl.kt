package com.az.network.users.rating

import com.az.model.users.rating.UserRatingData
import org.koin.dsl.module
import retrofit2.*

val userRatingApiModule = module {
    factory<UserRatingRemoteDataSource> { UserRatingRemoteDataSourceImpl(get()) }

    factory {
        get<Retrofit>().create(
            UserRatingApi::class.java
        )
    }
}

class UserRatingRemoteDataSourceImpl(
    private val userRatingApi: UserRatingApi
) : UserRatingRemoteDataSource {
    override fun getUserRating(
        userId: Int,
        onSuccess: (response: UserRatingData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        userRatingApi.getPosts(userId).enqueue(object : Callback<UserRatingData> {
            override fun onResponse(
                call: Call<UserRatingData>,
                response: Response<UserRatingData>
            ) {
                val body = response.body()
                if (body != null && response.isSuccessful) {
                    onSuccess(body)
                } else {
                    onFailure(HttpException(response))
                }
            }

            override fun onFailure(call: Call<UserRatingData>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}