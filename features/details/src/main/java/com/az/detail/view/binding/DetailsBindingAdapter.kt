package com.az.detail.view.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.detail.adapter.CommentsAdapter
import com.az.model.posts.detail.comments.CommentData
import com.az.model.users.rating.Rating

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<CommentData>?) {
    (view.adapter as? CommentsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}

@BindingAdapter(value = ["nickname", "rating"])
fun setNameWithGrade(view: TextView, nickname: String?, code: String?) {
    when (code) {
        Rating.ASSISTANT_MANAGE.code -> Rating.ASSISTANT_MANAGE.gradeName
        Rating.DEPARTMENT_HEAD.code -> Rating.DEPARTMENT_HEAD.gradeName
        Rating.MANAGING_DIRECTOR.code -> Rating.MANAGING_DIRECTOR.gradeName
        Rating.BOSS.code -> Rating.BOSS.gradeName
        else -> Rating.NEW_RECRUIT.gradeName
    }.let { grade ->
        view.text = "$grade ${nickname}님"
    }
}