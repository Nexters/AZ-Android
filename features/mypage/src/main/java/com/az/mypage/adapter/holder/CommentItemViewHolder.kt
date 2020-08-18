package com.az.mypage.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.model.posts.detail.comments.CommentData
import com.az.mypage.databinding.ItemMyCommentBinding

class CommentItemViewHolder(
    private val binding: ItemMyCommentBinding
) : RecyclerView.ViewHolder(binding.root) {

    init {

    }


    fun bind(item: CommentData) {
        with(binding) {
            commentItem = item
            executePendingBindings()
        }
    }

}