package com.az.create.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.az.core.Status
import com.az.model.posts.create.CreatePostRepository
import com.az.model.posts.create.CreatePostRequestData
import kotlinx.coroutines.launch

class CreateViewModel(
    private val createPostRepository: CreatePostRepository
) : ViewModel() {

    val humorText = MutableLiveData<String>()

    var toastMessageHandler: ((message: String) -> Unit)? = null
    var showSoftInputHandler: (() -> Unit)? = null
    var closeCreatePageHandler: (() -> Unit)? = null

    fun createPost() {
        if (isPostInvalid()) {
            return
        }
        viewModelScope.launch {
            val response = createPostRepository.createPost(CreatePostRequestData(humorText.value!!))
            when (response.status) {
                Status.SUCCESS -> closeCreatePageHandler?.invoke().also { showToast("개그작성완료") }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun isPostInvalid(): Boolean {
        return humorText.value.isNullOrBlank()
    }

    private fun showToast(message: String) = toastMessageHandler?.invoke(message)

    companion object {
        private const val TAG = "Create"
    }
}