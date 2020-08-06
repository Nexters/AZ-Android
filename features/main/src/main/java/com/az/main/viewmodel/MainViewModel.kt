package com.az.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.az.model.posts.PostData
import com.az.model.posts.PostsRepository
import com.az.model.posts.SimplePageData
import com.az.model.users.rating.UserRatingData
import com.az.model.users.rating.UserRatingRepository

const val userId = 1
const val size = 10

class MainViewModel(
    private val userRatingRepository: UserRatingRepository,
    private val postsRepository: PostsRepository
) : ViewModel() {

    private val _userRating = MutableLiveData<UserRatingData>()
    val userRating: LiveData<UserRatingData> = _userRating

    private val _humors = MutableLiveData<List<PostData>>()
    val humors: LiveData<List<PostData>> = _humors
    private lateinit var simplePageData: SimplePageData

    init {
        initSimplePageData()
        getUserRating()
        getPosts()
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(1, 0, 0)
    }

    private fun getUserRating() {
        userRatingRepository.getUserRating(
            userId,
            onSuccess = { response ->
                _userRating.value = response
            },
            onFailure = {
                // TODO : 바꿔야됨
            }
        )
    }

    private fun getPosts() {
        postsRepository.getPosts(
            simplePageData.currentPage,
            size,
            onSuccess = { response ->
                response.let {
                    _humors.value = it.posts
                    simplePageData = it.simplePage
                }
            },
            onFailure = {
                // TODO : 바꿔야됨
            }
        )
    }
}