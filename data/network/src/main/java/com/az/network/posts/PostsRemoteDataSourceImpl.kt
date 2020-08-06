package com.az.network.posts

import com.az.model.posts.PostsData
import org.koin.dsl.module
import retrofit2.*

val postsApiModule = module {
    factory<PostsRemoteDataSource> { PostsRemoteDataSourceImpl(get()) }

    factory {
        get<Retrofit>().create(
            PostsApi::class.java
        )
    }
}

class PostsRemoteDataSourceImpl(
    private val postsApi: PostsApi
) : PostsRemoteDataSource {
    override fun getPosts(
        currentPage: Int,
        size: Int,
        onSuccess: (response: PostsData) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        postsApi.getPosts(currentPage, size).enqueue(object : Callback<PostsData> {
            override fun onResponse(
                call: Call<PostsData>,
                response: Response<PostsData>
            ) {
                val body = response.body()
                if (body != null && response.isSuccessful) {
                    onSuccess(body)
                } else {
                    onFailure(HttpException(response))
                }
            }

            override fun onFailure(call: Call<PostsData>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}