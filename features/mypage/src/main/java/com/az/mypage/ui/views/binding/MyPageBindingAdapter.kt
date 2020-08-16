package com.az.mypage.ui.views.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.model.posts.PostData
import com.az.mypage.adapter.MyPageRecyclerViewAdapter
import java.util.Collections.replaceAll

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<PostData>?) {
    (view.adapter as? MyPageRecyclerViewAdapter)?.run {
        items?.let { replaceAll(it) }
//        notifyDataSetChanged()
    }
}