package com.az.signup.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.az.core.Status
import com.az.model.auth.AuthRepository
import com.az.model.users.identification.IdentificationRepository
import com.az.model.users.identification.IdentificationResponseData
import com.az.model.users.nickname.NicknameRepository
import kotlinx.coroutines.launch

class SignupViewModel(
    private val authRepository: AuthRepository,
    private val identificationRepository: IdentificationRepository,
    private val nicknameRepository: NicknameRepository
) : ViewModel() {

    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordCheck = MutableLiveData<String>()
    val nickname = MutableLiveData<String>()

    var toastMessageHandler: ((message: String) -> Unit)? = null
    var toBackStackHandler: (() -> Unit)? = null

    private val _isIdValid = MutableLiveData<Boolean>()
    val isIdValid: LiveData<Boolean> = _isIdValid
    private val _isNicknameValid = MutableLiveData<Boolean>()
    val isNicknameValid: LiveData<Boolean> = _isNicknameValid
    private val _isPassWordValid = MutableLiveData<Boolean>()
    val isPassWordValid: LiveData<Boolean> = _isPassWordValid

    private val _isSignUpValid = MutableLiveData<Boolean>()
    val isSignUpValid: LiveData<Boolean> = _isSignUpValid

    fun idExistenceCheck() {
        if (isIdInvalid()) return
        viewModelScope.launch {
            val response = identificationRepository.isIdentificationExist(id.value!!)
            when (response.status) {
                Status.SUCCESS -> handleIdentificationResponse(response.data!!)
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun isIdInvalid(): Boolean {
        id.value.let {
            return when {
                it.isNullOrBlank() -> true
                it.contains("\\s".toRegex()) -> true.also { showToast("공백은 허용되지 않습니다") }
                else -> true
            }
        }
    }

    private fun handleIdentificationResponse(response: IdentificationResponseData) {
        when (response.code) {
            CONTENT_EXIST_ALREADY -> _isIdValid.value = false
            AVAILABLE_CONTENT -> _isIdValid.value = true
            else -> showToast(response.message)
        }
    }

    /*private fun passWordValidationCheck(): Boolean {

    }

    private fun passWordCheckValidationCheck(): Boolean {

    }

    private fun nicknameValidationCheck(): Boolean {

    }

    private fun signUpValidationCheck() {

    }*/

    private fun showToast(message: String) = toastMessageHandler?.invoke(message)

    companion object {
        private const val TAG = "SignupViewModel"
        private const val CONTENT_EXIST_ALREADY = 201
        private const val AVAILABLE_CONTENT = 204
    }
}