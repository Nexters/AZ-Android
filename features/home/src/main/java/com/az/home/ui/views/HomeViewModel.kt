package com.az.home.ui.views

import android.util.Log
import androidx.lifecycle.ViewModel
import com.olaf.model.repository.GithubRepository

class HomeViewModel(
    private val githubRepository: GithubRepository
) : ViewModel() {

    fun getUserInfo() {
        githubRepository.getUserInfo(
            "nukeolaf",
            onSuccess = { response ->
                Log.d("통신 성공", response.toString())
            },
            onFailure = {
                // do something
            }
        )
    }

}