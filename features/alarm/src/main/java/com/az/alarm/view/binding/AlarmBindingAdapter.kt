package com.az.alarm.view.binding

import android.widget.TextView
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

@BindingAdapter("noticeType")
fun setNoticeType(view: TextView, type: String?) {
    return when (type) {
        "COMMENT" -> "댓글"
        "LIKE" -> "좋아요"
        else -> "error"
    }.let { view.text = it }
}