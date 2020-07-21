package com.az.home.ui.di

import android.util.Log
import com.az.di.repoModule
import com.az.home.ui.viewModel.HomeFragmentVm
import com.az.repository.github.InfoRepository
import com.az.repository.github.InfoRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import kotlin.math.sin


val infoModule = module {
    viewModel<HomeFragmentVm> { HomeFragmentVm(get()) }
}

val loadModules by lazy {
    loadKoinModules(listOf(infoModule))
}