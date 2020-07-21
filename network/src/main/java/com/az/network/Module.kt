package com.az.network

import com.az.api.GitHubAPI
import com.az.data.InfoDataSource
import com.az.data.InfoDataSourceImpl
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://api.github.com/"

val networkModule = module {

    single {
        Cache(androidApplication().cacheDir, 10L * 1024 * 1024)
    }

    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single {
        Interceptor { chain ->
//            chain.proceed(chain.request().newBuilder().apply {
//                header("", "")
//            }.build())
            chain.proceed(chain.request().newBuilder().build())
        }
    }

    single {
        OkHttpClient
            .Builder()
            .apply {
                cache(get())
                retryOnConnectionFailure(true)
                addInterceptor(get<Interceptor>())
                addInterceptor(get<HttpLoggingInterceptor>())
            }
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

val gitHubAPIModule = module {
    single<GitHubAPI> {
        get<Retrofit>().create(GitHubAPI::class.java)
    }
}

val dataSourceModule = module {
    single<InfoDataSource> { InfoDataSourceImpl(get() as GitHubAPI) }
}