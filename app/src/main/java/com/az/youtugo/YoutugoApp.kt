package com.az.youtugo

import android.app.Application
import com.az.core.di.sharedPreferencesModule
import com.az.network.auth.authApiModule
import com.az.network.networkModule
import com.az.network.posts.detail.comments.commentsApiModule
import com.az.network.posts.detail.postDetailApiModule
import com.az.network.posts.popular.postsPopularApiModule
import com.az.network.posts.postsApiModule
import com.az.network.users.rating.userRatingApiModule
import com.az.repository.auth.authRepositoryModule
import com.az.repository.posts.detail.comments.commentsRepositoryModule
import com.az.repository.posts.detail.postDetailRepositoryModule
import com.az.repository.posts.popular.postsPopularRepositoryModule
import com.az.repository.posts.postsRepositoryModule
import com.az.repository.users.rating.userRatingRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YoutugoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@YoutugoApp)
            modules(
                sharedPreferencesModule,
                networkModule,
                postsApiModule,
                postsRepositoryModule,
                postsPopularApiModule,
                postsPopularRepositoryModule,
                authApiModule,
                authRepositoryModule,
                userRatingApiModule,
                userRatingRepositoryModule,
                postDetailApiModule,
                postDetailRepositoryModule,
                commentsApiModule,
                commentsRepositoryModule,
                sharedPreferencesModule,
                userRatingRepositoryModule
            )
        }
    }
}