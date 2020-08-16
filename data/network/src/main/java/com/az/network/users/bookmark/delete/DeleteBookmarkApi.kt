package com.az.network.users.bookmark.delete

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path

interface DeleteBookmarkApi {
    @DELETE("/v1/api/users/bookmark/posts/{postId}")
    suspend fun deleteBookmark(
        @Path("postId") postId: Int
    ): Response<ResponseBody>
}