package com.az.detail.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.detail.TempCommentData
import com.az.detail.databinding.ItemCommentsBinding

class CommentItemViewHolder(private val binding: ItemCommentsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TempCommentData) {
        with(binding) {
            commentItem = item
            executePendingBindings()
        }
    }
}