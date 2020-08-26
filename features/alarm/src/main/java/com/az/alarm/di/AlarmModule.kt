package com.az.alarm.di

import com.az.alarm.viewmodel.AlarmViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val alarmViewModelModule = module {
    viewModel { AlarmViewModel() }
}

val loadFeature by lazy { loadKoinModules(alarmViewModelModule) }