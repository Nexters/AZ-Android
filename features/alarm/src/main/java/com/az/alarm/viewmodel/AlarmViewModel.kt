package com.az.alarm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.az.core.Preferences
import com.az.core.Status
import com.az.infinite_recyclerview.InfiniteViewModel
import com.az.model.posts.SimplePageData
import com.az.model.users.notices.DetailedNoticeData
import com.az.model.users.notices.NoticesRepository
import com.az.model.users.notices.delete.DeleteNoticeRepository
import kotlinx.coroutines.launch

class AlarmViewModel(
    private val noticesRepository: NoticesRepository,
    private val deleteNoticeRepository: DeleteNoticeRepository,
    sharedPrefs: Preferences
) : InfiniteViewModel<DetailedNoticeData>() {

    private val userId = sharedPrefs.getLoginSession()?.user?.id

    val alarms: LiveData<List<DetailedNoticeData?>> = items
    private lateinit var simplePageData: SimplePageData

    var toastMessageHandler: ((message: String) -> Unit)? = null
    var toLoginPageHandler: (() -> Unit)? = null

    init {
        checkUserIdExist()
        initSimplePageData()
        getItems()
    }

    private fun checkUserIdExist() {
        if (userId == null) {
            toLoginPageHandler?.invoke()
        }
    }

    private fun initSimplePageData() {
        simplePageData = SimplePageData(0, 0, 0)
    }

    private fun getCurrentPage(): Int {
        return simplePageData.currentPage + 1
    }

    override fun hasNextPage(): Boolean {
        return simplePageData.let { it.currentPage < it.totalPages }
    }

    override fun getItems() {
        setIsLoading(true)
        getNotices()
    }

    private fun getNotices() {
        viewModelScope.launch {
            val response = noticesRepository.getNotices(userId!!, getCurrentPage(), size)
            when (response.status) {
                Status.SUCCESS -> {
                    setItemLoadingView(false)
                    _items.value = items.value?.plus(response.data!!.detailedNoticeList)
                        ?: response.data!!.detailedNoticeList
                    simplePageData = response.data!!.simplePage
                }
                Status.ERROR -> Log.d(TAG, response.message!!)
            }
            setIsLoading(false)
        }
    }

    companion object {
        private val TAG = AlarmViewModel::class.simpleName
        private const val size = 10
    }

}