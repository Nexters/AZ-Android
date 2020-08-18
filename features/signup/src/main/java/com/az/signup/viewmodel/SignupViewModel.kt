package com.az.signup.viewmodel

import androidx.lifecycle.*
import com.az.core.Resource
import com.az.core.data.auth.request.SignUpRequestData
import com.az.model.auth.AuthRepository
import com.az.model.users.identification.IdentificationRepository
import com.az.model.users.nickname.NicknameRepository

class SignupViewModel(
    private val authRepository: AuthRepository,
    private val identificationRepository: IdentificationRepository,
    private val nicknameRepository: NicknameRepository
) : ViewModel() {

    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordCheck = MutableLiveData<String>()
    val nickname = MutableLiveData<String>()

    private val requestData = MutableLiveData<SignUpRequestData>()

    var toastMessageHandler: ((message: String) -> Unit)? = null
    var toBackStackHandler: (() -> Unit)? = null

    val isIdValid = Transformations.map(id) { idValidationCheck() }
    val isPassWordValid = Transformations.map(password) { passWordValidationCheck() }
    val isNicknameValid = Transformations.map(nickname) { nicknameValidationCheck() }

    private val _isSignUpValid = MutableLiveData<Boolean>()
    val isSignUpValid: LiveData<Boolean> = _isSignUpValid

    private fun idValidationCheck(): Boolean {
        // TODO API Call check id
        signUpValidationCheck()
        return !id.value.isNullOrBlank()
    }

    private fun passWordValidationCheck(): Boolean {
        signUpValidationCheck()
        return !password.value.isNullOrBlank() && password.value.equals(passwordCheck.value)
    }

    private fun nicknameValidationCheck(): Boolean {
        // TODO Call API
        signUpValidationCheck()
        return !nickname.value.isNullOrBlank()
    }

    private fun signUpValidationCheck() {
        _isSignUpValid.value =
            (isIdValid.value ?: false && isPassWordValid.value ?: false && isNicknameValid.value ?: false)
    }

    var signUp = requestData.switchMap { request ->
        liveData {
            emit(Resource.loading(null))
            emit(authRepository.signUp(request))
        }
    }

    fun onSignUpButtonClick() {
        requestData.value = SignUpRequestData(id.value!!, password.value!!, nickname.value!!)
    }
}