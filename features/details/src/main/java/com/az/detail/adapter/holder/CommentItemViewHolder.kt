package com.az.detail.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.detail.databinding.ItemCommentsBinding
import com.az.model.posts.detail.comments.CommentData

class CommentItemViewHolder(private val binding: ItemCommentsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CommentData) {
        with(binding) {
            commentItem = item
            executePendingBindings()
        }
    }
}