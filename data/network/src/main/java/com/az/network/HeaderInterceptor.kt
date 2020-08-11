package com.az.network

import com.az.core.Preferences
import okhttp3.Interceptor
import okhttp3.Response

const val TEMP_ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9" +
        ".eyJ1c2VySWQiOiIyMCIsInN1YiI6IkFjY2Vzc1Rva2VuIiwiaWF0IjoxNTk3MTQ2MzIwLCJleHAiOjE1OTcxNDk5MjB9" +
        ".4FzGGOndWTlGZQG6tMRw6sy6JP5CPuIPqgkxEARI9QfB8h9e_Ik9orufb0zpRBxaS5qL64lW7_WyjUqssedK9A"

class HeaderInterceptor(sharedPrefs: Preferences) : Interceptor {
    private val accessToken = TEMP_ACCESS_TOKEN

    init {
        /*accessToken = sharedPrefs.getLoginSession()*/
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return if (original.url().encodedPath().contains("auth/sign-in")
            || original.url().encodedPath().contains("auth/sign-up")
            || original.url().encodedPath().contains("auth/access-token")
        ) {
            chain.proceed(original)
        } else {
            chain.proceed(original.newBuilder().apply {
                addHeader("accessToken", accessToken)
            }.build())
        }
    }
}