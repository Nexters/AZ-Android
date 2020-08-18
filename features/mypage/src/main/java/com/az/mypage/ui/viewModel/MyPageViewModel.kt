package com.az.mypage.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.az.core.Preferences
import com.az.core.Resource
import com.az.core.Status
import com.az.infinite_recyclerview.InfiniteViewModel
import com.az.model.BaseDataInterface
import com.az.model.posts.PostData
import com.az.model.posts.PostsData
import com.az.model.posts.PostsRepository
import com.az.model.posts.SimplePageData
import com.az.model.posts.detail.comments.CommentData
import com.az.model.posts.detail.likes.LikePostRepository
import com.az.model.users.bookmark.BookmarksData
import com.az.model.users.bookmark.BookmarksRepository
import com.az.model.users.comments.UserCommentsRepository
import com.az.model.users.posts.UserPostsRepository
import com.az.mypage.model.MyPageItemCode
import com.az.mypage.model.SettingKey
import com.az.mypage.model.SettingModel
import kotlinx.coroutines.launch

const val size = 10

class MyPageViewModel(
    private val sharedPref: Preferences,
    private val postUserRepository: UserPostsRepository,
    private val bookmarkUserRepository: BookmarksRepository,
    private val commentUserRepository: UserCommentsRepository
) : InfiniteViewModel<BaseDataInterface>() {

    private val userId = sharedPref.getLoginSession()?.user?.id!!

    private val _selectItemCode = MutableLiveData<MyPageItemCode>(MyPageItemCode.MY_HUMORS)
    val selectItemCode get() = _selectItemCode

    private val _myHumors = MutableLiveData<List<PostData?>>()
    val myHumors get() = _myHumors

    private val _myComments = MutableLiveData<List<CommentData?>>()
    val myComments get() = _myComments

    private val _myBookmarks = MutableLiveData<List<PostData?>>()
    val myBookmarks get() = _myBookmarks

    private lateinit var simplePageData: SimplePageData

    private val _baseItems = MutableLiveData<List<BaseDataInterface>>()
    val baseItems get() = _baseItems

    private val setting: List<SettingModel> = arrayListOf(
        SettingModel(SettingKey.CHART, "아재트 조직도 정보"),
        SettingModel(SettingKey.PRIVACY, "개인정보 취급방침"),
        SettingModel(SettingKey.VERSION, "앱버전"),
        SettingModel(SettingKey.LOGOUT, "로그아웃"),
        SettingModel(SettingKey.WITHDRAWAL, "회원탈퇴")
    )

    init {
        initSimplePageData()
        getItems()
    }

    override fun hasNextPage(): Boolean {
        when (selectItemCode.value) {
            MyPageItemCode.MY_HUMORS,
            MyPageItemCode.MY_BOOKMARKS,
            MyPageItemCode.MY_COMMENTS -> {
                return simplePageData.currentPage < simplePageData.totalPages
            }
        }
        return false
    }

    override fun getItems() {
        setIsLoading(true)
        when (selectItemCode.value) {
            MyPageItemCode.MY_HUMORS -> {
                getMyHumors()
            }
            MyPageItemCode.MY_BOOKMARKS -> {
                getMyBookmark()
            }
            MyPageItemCode.MY_COMMENTS -> {
                getComments()
            }
            MyPageItemCode.SETTING -> {
                _baseItems.value = setting
            }
        }
        setIsLoading(false)
    }

    private fun getComments() {
        viewModelScope.launch {
            val response = commentUserRepository.getComments(
                userId, getCurrentPage(), size
            )
            when (response.status) {
                Status.SUCCESS -> {
                    baseItems.value?.plus(response.data!!.commentList)
                        ?: response.data!!.commentList
                }
                Status.ERROR -> {
                    Log.e("MyPage Comments", response.message!!)
                }
            }
        }
    }

    private fun getMyHumors() {
        viewModelScope.launch {
            val response = postUserRepository.getPosts(
                userId, getCurrentPage(), size
            )
            postResponse(response)
        }
    }

    private fun getMyBookmark() {
        viewModelScope.launch {
            val response = bookmarkUserRepository.getBookmarks(
                userId, getCurrentPage(), size
            )
            bookmarksResponse(response)
        }
    }

    private fun postResponse(response: Resource<PostsData>) {
        when (response.status) {
            Status.SUCCESS -> {
                baseItems.value =
                    baseItems.value?.plus(response.data!!.posts) ?: response.data!!.posts
                simplePageData = response.data!!.simplePage
            }
            Status.ERROR -> {
                Log.e("MyPage Humors", response.message!!)
            }
        }
    }

    // TODO 리팩토링.. PostData와 BookmarkData의 로직이 완전 동일한데 타입이 달라서 캐스팅이 안됨
    private fun bookmarksResponse(response: Resource<BookmarksData>) {
        when (response.status) {
            Status.SUCCESS -> {
                baseItems.value =
                    baseItems.value?.plus(response.data!!.posts) ?: response.data!!.posts
                simplePageData = response.data!!.simplePage
            }
            Status.ERROR -> {
                Log.e("MyPage Humors", response.message!!)
            }
        }
    }

    fun onSettingItemClickEvent(key: SettingKey) {
        when (key) {
            SettingKey.LOGOUT -> {
                sharedPref.clearLoginStatus()
                sharedPref.clearLoginSession()
            }
        }
    }

    fun onSelectMyPageItem(selectCode: MyPageItemCode) {
        initData()
        initSimplePageData()

        selectItemCode.value = selectCode
        getItems()
    }

    fun getUser() {
        sharedPref.getLoginSession()?.user
    }

    private fun initData() {
        baseItems.value = null
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(0, 0, 0)
    }

    private fun getCurrentPage(): Int {
        return simplePageData.currentPage + 1
    }
}