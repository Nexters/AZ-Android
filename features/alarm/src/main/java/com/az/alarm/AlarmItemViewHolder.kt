package com.az.alarm

import androidx.recyclerview.widget.RecyclerView
import com.az.alarm.databinding.ItemAlarmBinding

class AlarmItemViewHolder(
    private val binding: ItemAlarmBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TempAlarmData) {
        with(binding) {
            alarmItem = item
            executePendingBindings()
        }
    }
}