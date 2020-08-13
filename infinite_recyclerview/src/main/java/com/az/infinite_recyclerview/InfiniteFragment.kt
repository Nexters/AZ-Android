package com.az.infinite_recyclerview

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class InfiniteFragment<VM : InfiniteViewModel<ITEM>, ITEM : Any> : Fragment() {

    abstract val viewModel: VM

    protected fun setRecyclerViewScrollListener(view: RecyclerView) {
        view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = view.layoutManager
                if (viewModel.hasNextPage()) {
                    val lastVisibleItem = (layoutManager as LinearLayoutManager)
                        .findLastCompletelyVisibleItemPosition()
                    if (layoutManager.itemCount <= lastVisibleItem + 5) {
                        viewModel.loadMore()
                    }
                }
            }
        })
    }
}