package com.az.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {

    private val _details = MutableLiveData<TempHumorDetailData>()
    val details: LiveData<TempHumorDetailData> = _details
    private val _comments = MutableLiveData<List<TempCommentData>>()
    val comments: LiveData<List<TempCommentData>> = _comments

    private val comment = TempCommentData(
        "신입 가나다님",
        "ㅋㅋㅋㅋㅋㅋㅋㅋㅋ"
    )

    private val detail = TempHumorDetailData(
        "소나무가 삐지면?\n\n칫솔",
        48,
        10,
        "신입 가나다님",
        "한시간 전",
        isHeart = true,
        isBookmark = false
    )

    init {
        initDummyValues()
    }

    private fun initDummyValues() {
        _details.value = detail
        _comments.value = listOf(comment, comment, comment, comment, comment, comment, comment)
    }
}