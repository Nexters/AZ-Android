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

    val postCompleted = MutableLiveData<Boolean>().apply { value = false }

    fun createPost() {
        if (isPostInvalid()) {
            return
        }
        viewModelScope.launch {
            val response = createPostRepository.createPost(CreatePostRequestData(humorText.value!!))
            when (response.status) {
                Status.SUCCESS -> setPostCompleted()
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun isPostInvalid(): Boolean {
        return humorText.value.isNullOrBlank()
    }

    private fun setPostCompleted() {
        postCompleted.value = true
    }

    companion object {
        private const val TAG = "Create"
    }
}