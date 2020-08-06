package com.az.youtugo

import android.app.Application
import com.az.core.di.sharedPreferencesModule
import com.az.network.posts.postsApiModule
import com.az.network.users.rating.userRatingApiModule
import com.az.repository.posts.postsRepositoryModule
import com.az.repository.users.rating.userRatingRepositoryModule
import com.olaf.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YoutugoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@YoutugoApp)
            modules(
                networkModule,
                postsApiModule,
                postsRepositoryModule,
                userRatingApiModule,
                userRatingRepositoryModule,
                sharedPreferencesModule
            )
        }
    }
}