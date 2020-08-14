package com.az.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.az.core.LoginStatus
import com.az.core.Preferences
import com.az.core.Resource
import com.az.core.Status
import com.az.infinite_recyclerview.InfiniteViewModel
import com.az.model.posts.PostData
import com.az.model.posts.PostsData
import com.az.model.posts.PostsRepository
import com.az.model.posts.SimplePageData
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
) : InfiniteViewModel<PostData>() {

    private val loginStatus = sharedPrefs.getLoginStatus()
    private val loginSession = sharedPrefs.getLoginSession()

    private val _userRating = MutableLiveData<UserRatingData>()
    val userRating: LiveData<UserRatingData> = _userRating

    private val _isHumorsFame = MutableLiveData<Boolean>()
    val isHumorsFame: LiveData<Boolean> = _isHumorsFame

    val humors: LiveData<List<PostData?>> = items
    private lateinit var simplePageData: SimplePageData

    init {
        initIsHumorsFameData()
        initSimplePageData()
        getUserRating()
        getPosts()
    }

    override fun hasNextPage(): Boolean {
        return simplePageData.let { it.currentPage < it.totalPages }
    }

    override fun getItems() {
        setIsLoading(true)
        (isHumorsFame.value ?: false).let {
            when (it) {
                true -> getPopularPosts()
                false -> getPosts()
            }
        }
    }

    private fun initIsHumorsFameData() {
        _isHumorsFame.value = false
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(0, 0, 0)
    }

    private fun getCurrentPage(): Int {
        return simplePageData.currentPage + 1
    }

    fun toggleFame() {
        _isHumorsFame.value = (isHumorsFame.value ?: false).let { !it }.also {
            initSimplePageData()
            when (it) {
                true -> getPopularPosts()
                false -> getPosts()
            }
        }
    }

    private fun getUserRating() {
        val userId = loginSession?.user?.id

        if (userId == null) {
            handleLoginSessionExpired()
            return
        }

        viewModelScope.launch {
            val response = userRatingRepository.getUserRating(userId)
            when (response.status) {
                Status.SUCCESS -> _userRating.value = response.data
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun handleLoginSessionExpired() {
        if (loginStatus == LoginStatus.GUEST_LOGIN.status) {
            setGuestLoginStatus()
            return
        }
        // TODO : 로그인 화면으로 이동
    }

    private fun setGuestLoginStatus() {
        _userRating.value = UserRatingData(
            RatingForPromotionData(
                commentCountForPromotion = 0,
                currentRating = "NEW_RECRUIT",
                message = "게스트 로그인\n회원가입 필요",
                nextRating = "ASSISTANT_MANAGE",
                postCountForPromotion = 0,
                progress = 0F
            )
        )
    }

    private fun getPosts() {
        viewModelScope.launch {
            val response = postsRepository.getPosts(getCurrentPage(), size)
            handlePostResponse(response)
            setIsLoading(false)
        }
    }

    private fun getPopularPosts() {
        viewModelScope.launch {
            val response = postsPopularRepository.getPopularPosts(getCurrentPage(), size)
            handlePostResponse(response)
            setIsLoading(false)
        }
    }

    private fun handlePostResponse(response: Resource<PostsData>) {
        when (response.status) {
            Status.SUCCESS -> {
                setItemLoadingView(false)
                _items.value = items.value?.plus(response.data!!.posts) ?: response.data!!.posts
                simplePageData = response.data!!.simplePage
            }
            Status.ERROR -> Log.d(TAG, response.message!!)
        }
    }

    companion object {
        const val TAG = "MainViewModel"
    }
}