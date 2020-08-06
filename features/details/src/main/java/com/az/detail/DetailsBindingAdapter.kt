package com.az.detail

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<TempCommentData>?) {
    (view.adapter as? CommentsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}