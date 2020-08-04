package com.az.main

import androidx.recyclerview.widget.RecyclerView
import com.az.main.databinding.ItemHumorCardBinding

class MainHumorItemViewHolder(
    private val binding: ItemHumorCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TempHumorData) {
        with(binding) {
            humorItem = item
            executePendingBindings()
        }
    }
}