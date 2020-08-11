package com.az.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.az.model.posts.AuthorData
import com.az.model.posts.detail.DetailedPostData
import com.az.model.posts.detail.PostDetailData
import com.az.model.posts.detail.comments.CommentData

class DetailsViewModel : ViewModel() {

    private val _details = MutableLiveData<PostDetailData>()
    val details: LiveData<PostDetailData> = _details
    private val _comments = MutableLiveData<List<CommentData>>()
    val comments: LiveData<List<CommentData>> = _comments

    private val comment = CommentData(
        "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ",
        "2020-08-11T11:25:39.639Z",
        1234,
        "2020-08-11T11:25:39.639Z",
        123,
        "가나다"
    )

    private val detail = PostDetailData(
        DetailedPostData(
            AuthorData(0, "string", "가나다", "NEW_RECRUIT"),
            0, 0, "소나무가 삐지면?\n\n칫솔", "2020-08-11T11:27:10.860Z",
            0, 0, "2020-08-11T11:27:10.860Z", true
        )
    )

    init {
        initDummyValues()
    }

    private fun initDummyValues() {
        _details.value = detail
        _comments.value = listOf(comment, comment, comment, comment, comment, comment, comment)
    }
}