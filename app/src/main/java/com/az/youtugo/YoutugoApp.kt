package com.az.youtugo

import android.app.Application
import com.olaf.network.githubApiModule
import com.olaf.network.networkModule
import com.olaf.repository.di.githubRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YoutugoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@YoutugoApp)
            modules(
                networkModule,
                githubApiModule,
                githubRepositoryModule
            )
        }
    }
}