package com.az.infinite_recyclerview.example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.infinite_recyclerview.InfiniteRecyclerview
import com.az.infinite_recyclerview.LoadingViewHolder
import com.az.infinite_recyclerview.R
import com.az.infinite_recyclerview.databinding.ItemExampleBinding

class InfiniteAdapter : InfiniteRecyclerview<ExampleData>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val binding = DataBindingUtil.inflate<ItemExampleBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_example,
                    parent,
                    false
                )
                ExampleItemViewHolder(binding)
            }
            else -> {
                val inflatedView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_loading, parent, false)
                LoadingViewHolder(
                    inflatedView
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_ITEM -> {
                val viewHolder = holder as ExampleItemViewHolder
                viewHolder.bind(items[position]!!)
            }
        }
    }
}