package com.az.alarm.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.alarm.TempAlarmData
import com.az.alarm.adapter.AlarmsAdapter

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<TempAlarmData>?) {
    (view.adapter as? AlarmsAdapter)?.run {
        items?.let { replaceAll(it) } ?: replaceAll(listOf())
        notifyDataSetChanged()
    }
}