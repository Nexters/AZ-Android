package com.az.detail

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val detailsViewModelModule = module {
    viewModel { DetailsViewModel() }
}

val loadFeature by lazy { loadKoinModules(detailsViewModelModule) }