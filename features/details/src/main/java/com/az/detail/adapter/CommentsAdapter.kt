package com.az.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.detail.R
import com.az.detail.adapter.holder.CommentItemViewHolder
import com.az.detail.databinding.ItemCommentsBinding
import com.az.infinite_recyclerview.InfiniteRecyclerview
import com.az.infinite_recyclerview.LoadingViewHolder
import com.az.model.posts.detail.comments.CommentData

class CommentsAdapter : InfiniteRecyclerview<CommentData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                DataBindingUtil.inflate<ItemCommentsBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_comments,
                    parent,
                    false
                ).let {
                    CommentItemViewHolder(it)
                }
            }
            else -> {
                val inflatedView = LayoutInflater
                    .from(parent.context)
                    .inflate(com.az.infinite_recyclerview.R.layout.item_loading, parent, false)
                LoadingViewHolder(inflatedView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_ITEM -> {
                (holder as CommentItemViewHolder).bind(items[position]!!)
            }
        }
    }
}