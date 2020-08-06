package com.az.core.di

import com.az.core.Preferences
import com.az.core.PreferencesImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single<Preferences> { PreferencesImpl(androidApplication()) }
    single { PreferencesImpl(androidApplication()) }
}