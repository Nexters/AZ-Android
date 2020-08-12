package com.az.repository.posts.detail.comments

import com.az.model.Resource
import com.az.model.posts.detail.comments.CommentsData
import com.az.model.posts.detail.comments.CommentsRepository
import com.az.network.posts.detail.comments.CommentsRemoteDataSource
import org.koin.dsl.module

val commentsRepositoryModule = module {
    single<CommentsRepository> { CommentsRepositoryImpl(get()) }
}

class CommentsRepositoryImpl(
    private val commentsRemoteDataSource: CommentsRemoteDataSource
) : CommentsRepository {
    override suspend fun getComments(
        postId: Int,
        currentPage: Int,
        size: Int
    ): Resource<CommentsData> {
        return commentsRemoteDataSource.getComments(postId, currentPage, size)
    }
}