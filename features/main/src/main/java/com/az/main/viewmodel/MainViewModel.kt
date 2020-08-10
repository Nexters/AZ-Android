package com.az.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.az.model.posts.*
import com.az.model.users.rating.RatingForPromotionData
import com.az.model.users.rating.UserRatingData
import com.az.model.users.rating.UserRatingRepository

const val size = 10

class MainViewModel(
    private val userRatingRepository: UserRatingRepository,
    private val postsRepository: PostsRepository
) : ViewModel() {

    private val _userRating = MutableLiveData<UserRatingData>()
    val userRating: LiveData<UserRatingData> = _userRating

    private val _isHumorsFame = MutableLiveData<Boolean>()
    val isHumorsFame: LiveData<Boolean> = _isHumorsFame

    private val _humors = MutableLiveData<List<PostData>>()
    val humors: LiveData<List<PostData>> = _humors
    private lateinit var simplePageData: SimplePageData

    init {
        initHumorsFameData()
        initSimplePageData()
        getUserRating()
        getPosts()
    }

    private fun initHumorsFameData() {
        _isHumorsFame.value = false
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(1, 0, 0)
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

    private fun getPosts() {
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

    private fun getPopularPosts() {
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
}