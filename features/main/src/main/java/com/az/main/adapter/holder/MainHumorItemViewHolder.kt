package com.az.main.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.main.databinding.ItemHumorCardBinding
import com.az.model.posts.PostData

class MainHumorItemViewHolder(
    private val binding: ItemHumorCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostData, b: Boolean) {
        with(binding) {
            isFame = b
            humorItem = item
            executePendingBindings()
        }
    }
}