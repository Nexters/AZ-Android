package com.az.alarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.alarm.adapter.holder.AlarmItemViewHolder
import com.az.alarm.R
import com.az.alarm.TempAlarmData
import com.az.alarm.databinding.ItemAlarmBinding

class AlarmsAdapter : RecyclerView.Adapter<AlarmItemViewHolder>() {

    private val alarms = mutableListOf<TempAlarmData>()

    fun replaceAll(list: List<TempAlarmData>) {
        list.let {
            alarms.clear()
            alarms.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemAlarmBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_alarm,
            parent,
            false
        )
        return AlarmItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return alarms.size
    }

    override fun onBindViewHolder(holder: AlarmItemViewHolder, position: Int) {
        holder.bind(alarms[position])
    }
}