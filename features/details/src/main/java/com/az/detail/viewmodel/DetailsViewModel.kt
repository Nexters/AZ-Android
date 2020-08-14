package com.az.detail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.az.core.Preferences
import com.az.core.Status
import com.az.model.posts.AuthorData
import com.az.model.posts.SimplePageData
import com.az.model.posts.detail.DetailedPostData
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
) : ViewModel() {

    private var postId = 0

    private val _details = MutableLiveData<PostDetailData>()
    val details: LiveData<PostDetailData> = _details

    private val _comments = MutableLiveData<List<CommentData>>()
    val comments: LiveData<List<CommentData>> = _comments
    private lateinit var simplePageData: SimplePageData

    init {
        initSimplePageData()
    }

    fun setPostId(id: Int) {
        postId = id
        getPostDetail()
        getComments()
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(1, 0, 0)
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
                    _comments.value = response.data!!.commentList
                    simplePageData = response.data!!.simplePage
                }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
        }
    }

    companion object {
        private const val TAG = "DetailsViewModel"
    }
}