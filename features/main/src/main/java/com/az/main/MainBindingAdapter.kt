package com.az.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<TempHumorData>?) {
    (view.adapter as? MainHumorsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    } ?: MainHumorsAdapter().apply {
        view.adapter = this
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}