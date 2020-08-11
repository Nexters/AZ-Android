package com.az.network.posts.detail

import com.az.model.Resource
import com.az.model.posts.detail.PostDetailData
import com.az.network.responsehandler.ResponseHandler
import org.koin.dsl.module
import retrofit2.Retrofit

val postDetailApiModule = module {
    factory<PostDetailRemoteDataSource> { PostDetailRemoteDataSourceImpl(get(), get()) }

    factory {
        get<Retrofit>().create(
            PostDetailApi::class.java
        )
    }
}

class PostDetailRemoteDataSourceImpl(
    private val postDetailApi: PostDetailApi,
    private val responseHandler: ResponseHandler
) : PostDetailRemoteDataSource {
    override suspend fun getPostDetail(postId: Int): Resource<PostDetailData> {
        return try {
            postDetailApi.getPosts(postId).let { response ->
                responseHandler.handleSuccess(response)
            }
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}