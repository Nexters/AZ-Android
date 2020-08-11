package com.az.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.az.core.Preferences
import com.az.model.Status
import com.az.model.posts.*
import com.az.model.posts.popular.PostsPopularRepository
import com.az.model.users.rating.RatingForPromotionData
import com.az.model.users.rating.UserRatingData
import com.az.model.users.rating.UserRatingRepository
import kotlinx.coroutines.launch

const val size = 10

class MainViewModel(
    private val userRatingRepository: UserRatingRepository,
    private val postsRepository: PostsRepository,
    private val postsPopularRepository: PostsPopularRepository,
    sharedPrefs: Preferences
) : ViewModel() {

    private val loginStatus = sharedPrefs.getLoginStatus()
    private val loginSession = sharedPrefs.getLoginSession()

    private val _userRating = MutableLiveData<UserRatingData>()
    val userRating: LiveData<UserRatingData> = _userRating

    private val _isHumorsFame = MutableLiveData<Boolean>()
    val isHumorsFame: LiveData<Boolean> = _isHumorsFame

    private val _humors = MutableLiveData<List<PostData>>()
    val humors: LiveData<List<PostData>> = _humors
    private lateinit var simplePageData: SimplePageData

    init {
        initIsHumorsFameData()
        initSimplePageData()
        getFakeUserRating()
        getFakePosts()
    }

    private fun initIsHumorsFameData() {
        _isHumorsFame.value = false
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(1, 0, 0)
    }

    fun toggleFame() {
        _isHumorsFame.value = (isHumorsFame.value ?: false).let { !it }.also {
            initSimplePageData()
            when (it) {
                true -> getFakePopularPosts()
                false -> getFakePosts()
            }
        }
    }

    private fun getUserRating() {
        viewModelScope.launch {
            val response = userRatingRepository.getUserRating(123)
            when (response.status) {
                Status.SUCCESS -> _userRating.value = response.data
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun getPosts() {
        viewModelScope.launch {
            val response = postsRepository.getPosts(simplePageData.currentPage, size)
            when (response.status) {
                Status.SUCCESS -> {
                    _humors.value = response.data!!.posts
                    simplePageData = response.data!!.simplePage
                }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun getPopularPosts() {
        viewModelScope.launch {
            val response = postsPopularRepository.getPopularPosts(simplePageData.currentPage, size)
            when (response.status) {
                Status.SUCCESS -> {
                    _humors.value = response.data!!.posts
                    simplePageData = response.data!!.simplePage
                }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    /**
     * 아직 api 통신이 가능하지 않아서
     * 임시로 더미데이터를 반환하는 함수를 만들어두었습니다
     * */

    private fun getFakeUserRating() {
        _userRating.value = UserRatingData(
            RatingForPromotionData(
                commentCountForPromotion = 4,
                currentRating = "NEW_RECRUIT",
                message = "어이신입ㅋ\n유머 좀 하나?",
                nextRating = "ASSISTANT_MANAGE",
                postCountForPromotion = 14,
                progress = 0.7F
            )
        )
    }

    private fun fakeSimplePageDataResponse(): SimplePageData {
        return SimplePageData(
            simplePageData.currentPage + 1,
            30,
            3
        )
    }

    private fun getFakePosts() {
        val post = PostData(
            AuthorData(10, "string", "가나다", "NEW_RECRUIT"),
            0, 5, "소나무가 삐지면?", "2020-08-08T20:41:52.995Z",
            23, 2, "2020-08-08T20:41:52.995Z", true
        )

        PostsData(
            listOf(post, post, post, post, post, post, post, post, post, post),
            fakeSimplePageDataResponse()
        ).let {
            _humors.value = it.posts
            simplePageData = it.simplePage
        }
    }

    private fun getFakePopularPosts() {
        val post = PostData(
            AuthorData(11, "string", "라마바사", "NEW_RECRUIT"),
            0, 17, "쌀이 불에 타면?", "2020-08-08T20:41:52.995Z",
            25, 56, "2020-08-08T20:41:52.995Z", true
        )

        PostsData(
            listOf(post, post, post, post, post, post, post, post, post, post),
            fakeSimplePageDataResponse()
        ).let {
            _humors.value = it.posts
            simplePageData = it.simplePage
        }
    }

    companion object {
        const val TAG = "MainViewModel"
    }
}