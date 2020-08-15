package com.az.infinite_recyclerview

import androidx.recyclerview.widget.RecyclerView

abstract class InfiniteRecyclerview<ITEM : Any> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_LOADING = 1
    }

    protected val items = mutableListOf<ITEM?>()

    fun replaceAll(list: List<ITEM>) {
        list.let {
            items.clear()
            items.addAll(it)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            null -> VIEW_TYPE_LOADING
            else -> VIEW_TYPE_ITEM
        }
    }
}