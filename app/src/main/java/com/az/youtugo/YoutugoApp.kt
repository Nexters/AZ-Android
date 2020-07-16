package com.az.youtugo

import android.app.Application
import com.az.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YoutugoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@YoutugoApp)
            modules(listOf(networkModule))
        }
    }
}