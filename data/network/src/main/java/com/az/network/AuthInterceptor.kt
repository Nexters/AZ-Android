package com.az.network

import com.az.core.Preferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(val sharedPref: Preferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val token = sharedPref.getLoginSession()?.accessToken
        token?.let {
            req = req.newBuilder().addHeader("accessToken", it.token).build()
        }
        return chain.proceed(req)
    }
}