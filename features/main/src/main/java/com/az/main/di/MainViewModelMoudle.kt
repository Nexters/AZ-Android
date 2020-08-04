package com.az.main.di

import com.az.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel { MainViewModel() }
}

val loadFeature by lazy { loadKoinModules(mainViewModelModule) }