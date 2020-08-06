package com.az.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _userGrade = MutableLiveData<String>()
    val userGrade: LiveData<String> = _userGrade
    private val _userGradeText = MutableLiveData<String>()
    val userGradeText: LiveData<String> = _userGradeText

    private val _postCount = MutableLiveData<Int>()
    val postCount: LiveData<Int> = _postCount
    private val _commentCount = MutableLiveData<Int>()
    val commentCount: LiveData<Int> = _commentCount

    private val _humorGradeProgress = MutableLiveData<Int>()
    val humorGradeProgress: LiveData<Int> = _humorGradeProgress

    private val _humors = MutableLiveData<List<TempHumorData>>()
    val humors: LiveData<List<TempHumorData>> = _humors

    private val _isRecyclerViewScrollable = MutableLiveData<Boolean>()
    val isRecyclerViewScrollable: LiveData<Boolean> = _isRecyclerViewScrollable

    private val humor = TempHumorData(
        "신입",
        "가나다",
        "2020.02.22",
        "소나무가\n삐지면?",
        48,
        10,
        false
    )

    init {
        initDummyValues()
    }

    private fun initDummyValues() {
        _userGrade.value = "유머쪼랩ㅋ"
        _userGradeText.value = "분발하자^^"
        _postCount.value = 14
        _commentCount.value = 4
        _humorGradeProgress.value = 70
        _humors.value = listOf(humor, humor, humor, humor, humor)
        _isRecyclerViewScrollable.value = false
    }

    fun setScrollable(b: Boolean) {
        _isRecyclerViewScrollable.value = b
    }
}