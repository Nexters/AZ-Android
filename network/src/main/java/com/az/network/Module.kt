package com.az.network

import com.az.data.InfoDataSource
import com.az.data.InfoDataSourceImpl
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_URL = "http://api.github.com/"

val networkModule = module {

    single {
        Cache(androidApplication().cacheDir, 10L * 1024 * 1024)
    }

    single {
        OkHttpClient
            .Builder()
            .apply {
                cache(get())
                retryOnConnectionFailure(true)
                addInterceptor{ chain ->
                    chain.proceed(chain.request().newBuilder().apply {
                        header("", "")
                    }.build())
                }
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                })
            }
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .build()
    }

    single { InfoDataSourceImpl(get()) as InfoDataSource }

}