package com.az.youtugo

import android.app.Application
import com.az.core.di.sharedPreferencesModule
import com.olaf.network.auth.apiModule
import com.olaf.network.networkModule
import com.olaf.repository.auth.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YoutugoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@YoutugoApp)
            modules(
                networkModule,
                apiModule,
                authModule,
                sharedPreferencesModule
            )
        }
    }
}