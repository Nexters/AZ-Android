package com.az.mypage.di

import com.az.mypage.ui.viewModel.MyPageViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val myPageModule = module {
    viewModel { MyPageViewModel(get(), get(), get(), get()) }
}

val loadFeature by lazy { loadKoinModules(myPageModule) }