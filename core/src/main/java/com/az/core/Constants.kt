package com.az.core

object Constants {
    const val SHARED_PREF_FILE_NAME = "com.az"
}

object SHARED_PREF_KEY {

    const val LOGIN_STATUS = "loginStatus"
}

enum class LoginStatus(val status: Int) {
    UNDEFINED(0),
    USER_LOGIN(1),
    GUEST_LOGIN(2),
    ADMIN_LOGIN(3),
}