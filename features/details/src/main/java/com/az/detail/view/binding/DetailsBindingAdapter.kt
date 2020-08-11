package com.az.detail.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.detail.adapter.CommentsAdapter
import com.az.model.posts.detail.comments.CommentData

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<CommentData>?) {
    (view.adapter as? CommentsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}