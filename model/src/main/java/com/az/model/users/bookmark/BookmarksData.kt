package com.az.model.users.bookmark

import com.az.model.posts.PostData
import com.az.model.posts.SimplePageData

data class BookmarksData(
    val posts: List<PostData>,
    val simplePage: SimplePageData
)