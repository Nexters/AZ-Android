package com.az.login.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.az.core.Preferences
import com.az.core.Resource
import com.az.core.data.auth.request.SignInRequestData
import com.az.core.data.auth.response.SignInResponseData
import com.az.model.auth.AuthRepository

class LoginViewModel(private val repo: AuthRepository, private val sharedPrefs: Preferences) : ViewModel() {

    private val _id = MutableLiveData<String>()
    val id get() = _id

    private val _password = MutableLiveData<String>()
    val password get() = _password

    private val requestData = MutableLiveData<SignInRequestData>()

    val login = requestData.switchMap { request ->
        liveData {
            emit(Resource.loading(null))
            emit(repo.login(request))
        }
    }

    fun onLoginButtonClick() {
        requestData.value = SignInRequestData(id.value!!, password.value!!)
    }

    fun setUserSession(userData: SignInResponseData) {
        sharedPrefs.setLoginSession(userData)
    }
}