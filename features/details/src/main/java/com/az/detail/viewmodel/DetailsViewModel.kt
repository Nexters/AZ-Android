package com.az.detail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.az.core.LoginStatus
import com.az.core.Preferences
import com.az.core.Status
import com.az.infinite_recyclerview.InfiniteViewModel
import com.az.model.posts.SimplePageData
import com.az.model.posts.detail.PostDetailData
import com.az.model.posts.detail.PostDetailRepository
import com.az.model.posts.detail.comments.CommentData
import com.az.model.posts.detail.comments.CommentsRepository
import kotlinx.coroutines.launch

const val size = 10

class DetailsViewModel(
    private val postDetailRepository: PostDetailRepository,
    private val commentsRepository: CommentsRepository,
    sharedPrefs: Preferences
) : InfiniteViewModel<CommentData>() {

    private var postId = 0

    private val loginStatus = sharedPrefs.getLoginStatus()
    private val loginSession = sharedPrefs.getLoginSession()

    private val _details = MutableLiveData<PostDetailData>()
    val details: LiveData<PostDetailData> = _details

    val comments: LiveData<List<CommentData?>> = items
    private lateinit var simplePageData: SimplePageData

    init {
        initSimplePageData()
    }

    fun isGuestLogin(): Boolean {
        return loginStatus == LoginStatus.GUEST_LOGIN.status
    }

    fun setPostId(id: Int) {
        postId = id
        getPostDetail()
        getItems()
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(1, 0, 0)
    }

    override fun hasNextPage(): Boolean {
        return simplePageData.let { it.currentPage < it.totalPages }
    }

    override fun getItems() {
        setIsLoading(true)
        getComments()
    }

    private fun getPostDetail() {
        viewModelScope.launch {
            val response = postDetailRepository.getPostDetail(postId)
            when (response.status) {
                Status.SUCCESS -> _details.value = response.data
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    private fun getComments() {
        viewModelScope.launch {
            val response = commentsRepository.getComments(postId, simplePageData.currentPage, size)
            when (response.status) {
                Status.SUCCESS -> {
                    setItemLoadingView(false)
                    _items.value = items.value?.plus(response.data!!.commentList)
                        ?: response.data!!.commentList
                    simplePageData = response.data!!.simplePage
                }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
            setIsLoading(false)
        }
    }

    companion object {
        private const val TAG = "DetailsViewModel"
    }
}