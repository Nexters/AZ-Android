package com.az.signup.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.az.core.Status
import com.az.core.data.auth.request.SignUpRequestData
import com.az.model.auth.AuthRepository
import com.az.model.users.identification.IdentificationRepository
import com.az.model.users.identification.IdentificationResponseData
import com.az.model.users.nickname.NicknameRepository
import com.az.model.users.nickname.NicknameResponseData
import kotlinx.coroutines.launch
import java.util.regex.Pattern

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
                Status.ERROR -> _isIdValid.value = false.also { Log.d(TAG, response.message!!) }
            }
        }.also { signUpValidationCheck() }
    }

    private fun isIdInvalid(): Boolean {
        id.value.let {
            return when {
                it.isNullOrBlank() -> true.also { showToast("아이디를 입력해주세요") }
                it.contains("\\s".toRegex()) -> true.also { showToast("아이디 공백은 허용되지 않습니다") }
                it.length < 2 -> true.also { showToast("아이디는 두 글자 이상 입력해주세요") }
                else -> false
            }
        }
    }

    private fun handleIdentificationResponse(response: IdentificationResponseData) {
        when (response.code) {
            AVAILABLE_CONTENT -> _isIdValid.value = true
            else -> _isIdValid.value = false
        }
    }

    fun nicknameExistenceCheck() {
        if (isNicknameInvalid()) return
        viewModelScope.launch {
            val response = nicknameRepository.isNicknameExist(nickname.value!!)
            when (response.status) {
                Status.SUCCESS -> handleNicknameResponse(response.data!!)
                Status.ERROR -> _isNicknameValid.value =
                    false.also { Log.d(TAG, response.message!!) }
            }
        }.also { signUpValidationCheck() }
    }

    private fun isNicknameInvalid(): Boolean {
        nickname.value.let {
            return when {
                it.isNullOrBlank() -> true.also { showToast("닉네임을 입력해주세요") }
                it.contains("\\s".toRegex()) -> true.also { showToast("닉네임 공백은 허용되지 않습니다") }
                it.length < 2 -> true.also { showToast("닉네임은 두 글자 이상 입력해주세요") }
                !Pattern.matches("^[가-힣]*$", it) -> true.also { showToast("닉네임은 한글만 입력가능합니다") }
                else -> false
            }
        }
    }

    private fun handleNicknameResponse(response: NicknameResponseData) {
        when (response.code) {
            AVAILABLE_CONTENT -> _isNicknameValid.value = true
            else -> _isNicknameValid.value = false
        }
    }

    val passWordValidationCheck = {
        _isPassWordValid.value = password.value.equals(passwordCheck.value)
        signUpValidationCheck()
    }

    private fun signUpValidationCheck() {
        _isSignUpValid.value =
            (isIdValid.value ?: false && isPassWordValid.value ?: false && isNicknameValid.value ?: false)
    }

    fun signUp() {
        if (id.value.isNullOrBlank()) {
            showToast("아이디를를 입력해주세요")
            return
        }
        if (password.value.isNullOrBlank()) {
            showToast("패스워드를 입력해주세요")
            return
        }
        if (password.value!!.length < 8) {
            showToast("패스워드는 8글자 이상 입력해주세요")
        }
        if (passwordCheck.value.isNullOrBlank()) {
            showToast("패스워드를 확인해주세요")
            return
        }
        if (nickname.value.isNullOrBlank()) {
            showToast("닉네임을 입력해주세요")
            return
        }
        if (isIdValid.value == false || isIdValid.value == null) {
            showToast("아이디 중복을 확인해주세요")
        }
        if (isNicknameValid.value == false || isNicknameValid.value == null) {
            showToast("닉네임 중복을 확인해주세요")
        }
        if (isSignUpValid.value == false) return


        viewModelScope.launch {
            val response = authRepository.signUp(getSignUpRequest())
            when (response.status) {
                Status.SUCCESS -> toBackStackHandler?.invoke().also { showToast("회원가입 완료") }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun getSignUpRequest(): SignUpRequestData {
        return SignUpRequestData(id.value!!, password.value!!, nickname.value!!)
    }

    private fun showToast(message: String) = toastMessageHandler?.invoke(message)

    companion object {
        private const val TAG = "SignupViewModel"
        private const val AVAILABLE_CONTENT = 204
    }
}