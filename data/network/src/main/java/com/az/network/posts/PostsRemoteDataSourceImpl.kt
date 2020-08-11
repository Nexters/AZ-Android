package com.az.network.posts

import com.az.model.Resource
import com.az.model.posts.PostsData
import com.az.network.responsehandler.ResponseHandler
import org.koin.dsl.module
import retrofit2.Retrofit

val postsApiModule = module {
    factory<PostsRemoteDataSource> { PostsRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            PostsApi::class.java
        )
    }
}

class PostsRemoteDataSourceImpl(
    private val postsApi: PostsApi,
    private val responseHandler: ResponseHandler
) : PostsRemoteDataSource {
    override suspend fun getPosts(currentPage: Int, size: Int): Resource<PostsData> {
        return try {
            postsApi.getPosts(currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}