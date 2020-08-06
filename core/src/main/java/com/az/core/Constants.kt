package com.az.core

object Constants {
    const val SHARED_PREF_FILE_NAME = "com.az"
}

object SHARED_PREF_KEY {

    const val LOGIN_STATUS = "loginStatus"
}

enum class LOGIN_STATUS {
    USER_LOGIN,
    GUEST_LOGIN,
    ADMIN_LOGIN,
    UNDEFINED
}