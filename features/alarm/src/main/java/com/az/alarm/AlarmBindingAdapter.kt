package com.az.alarm

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<TempAlarmData>?) {
    (view.adapter as? AlarmsAdapter)?.run {
        items?.let { replaceAll(it) } ?: replaceAll(listOf())
        notifyDataSetChanged()
    }
}