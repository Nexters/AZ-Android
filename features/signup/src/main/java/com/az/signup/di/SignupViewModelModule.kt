package com.az.signup.di

import com.az.signup.SignupViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signupViewModelModule = module {
    viewModel { SignupViewModel(get()) }
}