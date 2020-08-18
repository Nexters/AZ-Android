package com.az.mypage.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.mypage.adapter.holder.listener.SettingItemListener
import com.az.mypage.databinding.ItemMySettingBinding
import com.az.mypage.model.SettingModel

class SettingItemViewHolder(
    private val binding: ItemMySettingBinding,
    listener: SettingItemListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = listener
    }

    fun bind(item: SettingModel) {
        with(binding) {
            settingItem = item
            executePendingBindings()
        }
    }
}