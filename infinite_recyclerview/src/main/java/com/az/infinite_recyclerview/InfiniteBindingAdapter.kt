package com.az.infinite_recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.infinite_recyclerview.example.ExampleData
import com.az.infinite_recyclerview.example.InfiniteAdapter

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<ExampleData>?) {
    (view.adapter as? InfiniteAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}