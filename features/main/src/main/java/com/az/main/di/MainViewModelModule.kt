package com.az.main.di

import com.az.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel { MainViewModel(get(), get(), get(), get()) }
}

val loadFeature by lazy { loadKoinModules(mainViewModelModule) }