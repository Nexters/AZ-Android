package com.az.detail.di

import com.az.detail.DetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val detailsViewModelModule = module {
    viewModel { DetailsViewModel() }
}

val loadFeature by lazy { loadKoinModules(detailsViewModelModule) }