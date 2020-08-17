package com.az.mypage.data

import com.az.model.posts.PostData
import com.az.model.posts.detail.comments.CommentData
import com.az.mypage.model.SettingModel

data class MyPageData(
    val myHumors: List<PostData>,
    val myComments: List<CommentData>,
    val myBookmarks: List<PostData>,
    val setting: List<SettingModel>
)