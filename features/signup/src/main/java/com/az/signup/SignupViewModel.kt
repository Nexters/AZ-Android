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

    private val _validId = MutableLiveData<Boolean>(false)
    val validId get() = _validId

    private val _validPassword = MutableLiveData<Boolean>(false)
    val validPassword get() = _validPassword

    private val _validNickname = MutableLiveData<Boolean>(false)
    val validNickname get() = _validNickname

    private val _validSignUp = MutableLiveData<Boolean>(false)
    val validSignUp get() = _validSignUp

    fun validId() {
        // TODO API Call check id
        validId.value = !id.value.isNullOrEmpty()
    }

    fun validPassword() {
        validPassword.value =
            !password.value.isNullOrEmpty() && password.value.equals(passwordCheck.value)
    }

    fun validNickname() {
        // TODO Call API
        validNickname.value = !nickname.value.isNullOrEmpty()
    }

    fun validSignUp() {
        validSignUp.value = (validId.value!! && validPassword.value!! && validNickname.value!!)
    }

    fun onClick() {
        Log.d("TAG", "${id.value} / ${password.value} / ${passwordCheck.value} / ${nickname.value}")
    }

}