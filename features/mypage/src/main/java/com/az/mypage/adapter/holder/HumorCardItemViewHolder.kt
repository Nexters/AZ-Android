package com.az.mypage.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.model.posts.PostData
import com.az.mypage.adapter.holder.listener.HumorItemListener
import com.az.mypage.databinding.ItemMyHumorCardBinding

class HumorCardItemViewHolder(
    private val binding: ItemMyHumorCardBinding,
    listener: HumorItemListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = listener
    }

    fun bind(item: PostData) {
        with(binding) {
            humorItem = item
            executePendingBindings()
        }
    }
}