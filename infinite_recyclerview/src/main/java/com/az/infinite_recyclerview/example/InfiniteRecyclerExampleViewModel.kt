package com.az.infinite_recyclerview.example

import androidx.lifecycle.LiveData
import com.az.infinite_recyclerview.InfiniteViewModel

class InfiniteRecyclerExampleViewModel : InfiniteViewModel<ExampleData>() {

    val itemList: LiveData<List<ExampleData?>> = items

    private lateinit var simplePageData: ExampleSimplePageData

    init {
        initSimplePageData()
        _items.value = getExampleItems()
    }

    private fun initSimplePageData() {
        simplePageData = ExampleSimplePageData(0, 50, 5)
    }

    override fun hasNextPage(): Boolean {
        return simplePageData.let { it.currentPage < it.totalPages }
    }

    override fun getItems() {
        simplePageData = simplePageData.copy(currentPage = simplePageData.currentPage + 1)
        setItemLoadingView(false)
        _items.value = _items.value?.plus(getExampleItems()) ?: getExampleItems()
    }

    private fun getExampleItems(): List<ExampleData> {
        val age = 0
        val list = mutableListOf<ExampleData>()
        for (i in 1..10) {
            list.add(ExampleData("양혜진", age + i))
        }
        return list
    }

}