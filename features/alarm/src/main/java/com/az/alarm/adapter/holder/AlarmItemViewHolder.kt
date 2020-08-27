package com.az.alarm.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.az.alarm.adapter.holder.listener.AlarmItemListener
import com.az.alarm.databinding.ItemAlarmBinding
import com.az.model.users.notices.DetailedNoticeData

class AlarmItemViewHolder(
    private val binding: ItemAlarmBinding,
    listener: AlarmItemListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = listener
    }

    fun bind(item: DetailedNoticeData) {
        with(binding) {
            alarmItem = item
            executePendingBindings()
        }
    }
}