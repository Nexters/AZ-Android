package com.az.detail.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.detail.adapter.CommentsAdapter

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<TempCommentData>?) {
    (view.adapter as? CommentsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}