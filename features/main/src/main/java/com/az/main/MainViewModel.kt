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
}