package com.az.login.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun onClickSignupButton() {

    }
}