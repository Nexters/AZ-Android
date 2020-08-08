package com.az.main.view

import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.model.posts.PostData

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<PostData>?) {
    (view.adapter as? MainHumorsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}

@BindingAdapter("conciergeGrade")
fun setConciergeGrade(view: TextView, message: String) {
    view.text = message.split("\n").first()
}

@BindingAdapter("conciergeMessage")
fun setConciergeMessage(view: TextView, message: String) {
    view.text = message.split("\n").last()
}

@BindingAdapter("humorGradeProgress")
fun setHumorGradeProgress(view: ProgressBar, progress: Float) {
    view.progress = (progress * 1000).toInt()
}