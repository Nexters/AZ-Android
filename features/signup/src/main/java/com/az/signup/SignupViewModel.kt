package com.az.signup

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel() {

    private val _id = MutableLiveData<String>()
    val id get() = _id

    private val _password = MutableLiveData<String>()
    val password get() = _password

    private val _passwordCheck = MutableLiveData<String>()
    val passwordCheck get() = _passwordCheck

    private val _nickname = MutableLiveData<String>()
    val nickname get() = _nickname

    fun enabledSignup() = validId() && validPassword() && validNickname()


    fun validId(): Boolean {
        // TODO API Call check id
        return !id.value.isNullOrEmpty()
    }

    fun validPassword(): Boolean = !password.value.isNullOrEmpty() && password.value.equals(passwordCheck.value)

    fun validNickname(): Boolean {
        return !nickname.value.isNullOrEmpty()
    }

    fun onClick() {
        Log.d("TAG", "${id.value} / ${password.value} / ${passwordCheck.value} / ${nickname.value}")
    }

}