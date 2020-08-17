package com.az.create.di

import com.az.create.viewmodel.CreateViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val createViewModelModule = module {
    viewModel { CreateViewModel(get()) }
}

val loadFeature by lazy { loadKoinModules(createViewModelModule) }