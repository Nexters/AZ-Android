package com.az.login.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.az.core.Resource
import com.az.core.data.auth.request.SignInRequestData
import com.az.model.auth.AuthRepository

class LoginViewModel(val repo: AuthRepository) : ViewModel() {

    val _id = MutableLiveData<String>()
    val id get() = _id

    val _password = MutableLiveData<String>()
    val password get() = _password

    val requestData = MutableLiveData<SignInRequestData>()

    val login = requestData.switchMap { request ->
        liveData {
            emit(Resource.loading(null))
            emit(repo.login(request))
        }
    }

    fun onClick() {
        Log.d("tag", "click")
        requestData.value = SignInRequestData(id.value!!, password.value!!)
    }
}