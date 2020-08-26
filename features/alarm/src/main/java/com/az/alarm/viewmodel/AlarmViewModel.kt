package com.az.alarm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.az.alarm.TempAlarmData

class AlarmViewModel : ViewModel() {
    private val _alarms = MutableLiveData<List<TempAlarmData>>()
    val alarms: LiveData<List<TempAlarmData>> = _alarms

    private val alarm = TempAlarmData(
        "밤에 성시경이 두명이라면?",
        "작성글에 새 좋아요가 등록되었습니다",
        "5분 전"
    )

    init {
        initDummyValues()
    }

    private fun initDummyValues() {
        _alarms.value = listOf(alarm, alarm, alarm)
    }
}