package com.az.core

import android.content.SharedPreferences

interface Preferences {
    val sharedPref: SharedPreferences

    fun getLoginStatus(): Int
    fun setLoginStatus(status: LoginStatus)
}