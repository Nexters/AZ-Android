package com.az.mypage.ui.views.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.model.BaseDataInterface
import com.az.mypage.adapter.MyPageRecyclerViewAdapter
import com.az.mypage.model.MyPageItemCode

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<BaseDataInterface>?) {
    (view.adapter as MyPageRecyclerViewAdapter).run {
        items?.let {
            replaceAll(it)
            notifyDataSetChanged()
        }
    }
}

@BindingAdapter("setViewType")
fun setViewType(view: RecyclerView, viewType: MyPageItemCode) {
    (view.adapter as MyPageRecyclerViewAdapter).run {
        this.changeViewType(viewType)
    }
}