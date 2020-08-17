package com.az.mypage.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.model.posts.PostData
import com.az.mypage.databinding.ItemMyHumorCardBinding

class HumorCardItemViewHolder(private val binding: ItemMyHumorCardBinding)
    : RecyclerView.ViewHolder(binding.root) {

    init {

    }

    fun bind(item: PostData) {
        with(binding) {
            humorItem = item
            executePendingBindings()
        }
    }
}