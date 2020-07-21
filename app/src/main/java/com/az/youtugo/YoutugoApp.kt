package com.az.youtugo

import android.app.Application
import com.az.di.repoModule
import com.az.network.dataSourceModule
import com.az.network.gitHubAPIModule
import com.az.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YoutugoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@YoutugoApp)
            modules(listOf(networkModule, dataSourceModule, gitHubAPIModule, repoModule))
        }
    }
}