package com.az.network.posts.popular

import com.az.model.Resource
import com.az.model.posts.PostsData
import com.az.network.responsehandler.ResponseHandler
import org.koin.dsl.module
import retrofit2.Retrofit

val postsPopularApiModule = module {
    factory<PostsPopularRemoteDataSource> { PostsPopularRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            PostsPopularApi::class.java
        )
    }
}


class PostsPopularRemoteDataSourceImpl(
    private val postsPopularApi: PostsPopularApi,
    private val responseHandler: ResponseHandler
) : PostsPopularRemoteDataSource {
    override suspend fun getPopularPosts(currentPage: Int, size: Int): Resource<PostsData> {
        return try {
            postsPopularApi.getPopularPosts(currentPage, size).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}