package com.az.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.az.core.Resource
import com.az.core.data.auth.request.SignUpRequestData
import com.az.model.auth.AuthRepository

class SignupViewModel(val repo: AuthRepository) : ViewModel() {

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

    private val requestData = MutableLiveData<SignUpRequestData>()

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

    var signUp = requestData.switchMap { item ->
        liveData {
            emit(Resource.loading(null))
            emit(repo.signUp(item))
        }
    }

    fun onClick() {
        requestData.value = SignUpRequestData(id.value!!, password.value!!, nickname.value!!)
    }
}