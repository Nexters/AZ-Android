package com.az.detail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.az.core.Preferences
import com.az.model.Status
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
        initDummyValues()
    }

    fun setPostId(id: Int) {
        postId = id
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

    /**
     * 아직 api 통신이 가능하지 않아서
     * 임시로 더미데이터를 반환하는 함수를 만들어두었습니다
     * */

    private fun initDummyValues() {
        val comment = CommentData(
            "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ",
            "2020-08-11T11:25:39.639Z",
            1234,
            "2020-08-11T11:25:39.639Z",
            123,
            "가나다"
        )
        val detail = PostDetailData(
            DetailedPostData(
                AuthorData(0, "string", "가나다", "NEW_RECRUIT"),
                0, 0, "소나무가 삐지면?\n\n칫솔", "2020-08-11T11:27:10.860Z",
                0, 0, "2020-08-11T11:27:10.860Z", true
            )
        )

        _details.value = detail
        _comments.value = listOf(comment, comment, comment, comment, comment, comment, comment)
    }

    companion object {
        private const val TAG = "DetailsViewModel"
    }
}