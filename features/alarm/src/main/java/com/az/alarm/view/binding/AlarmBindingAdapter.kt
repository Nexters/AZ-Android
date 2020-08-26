package com.az.alarm.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.alarm.adapter.AlarmsAdapter
import com.az.model.users.notices.DetailedNoticeData

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<DetailedNoticeData>?) {
    (view.adapter as? AlarmsAdapter)?.run {
        items?.let { replaceAll(it) } ?: replaceAll(listOf())
        notifyDataSetChanged()
    }
}