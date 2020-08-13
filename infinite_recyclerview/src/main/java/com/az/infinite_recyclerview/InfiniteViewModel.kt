package com.az.infinite_recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class InfiniteViewModel<ITEM : Any> : ViewModel() {
    protected val _items = MutableLiveData<List<ITEM?>>()
    val items: LiveData<List<ITEM?>> = _items

    abstract fun hasNextPage(): Boolean

    fun loadMore() {
        setItemLoadingView(true)
        getItems()
    }

    protected abstract fun getItems()

    protected fun setItemLoadingView(isLoadingView: Boolean) {
        val list = items.value
        val nullPost: ITEM? = null
        if (list.isNullOrEmpty()) {
            return
        }
        if (isLoadingView) {
            _items.value = list.plus(nullPost)
            return
        }
        if (list[list.size - 1] != null) {
            return
        }

        _items.value = list.filterIndexed { index, _ ->
            index < list.size - 1
        }
    }

}