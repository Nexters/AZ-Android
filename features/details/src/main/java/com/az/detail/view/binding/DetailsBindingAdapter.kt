package com.az.detail.view.binding

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.detail.R
import com.az.detail.adapter.CommentsAdapter
import com.az.model.posts.detail.comments.CommentData
import com.az.model.users.rating.Rating

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<CommentData>?) {
    (view.adapter as? CommentsAdapter)?.run {
        items?.let { replaceAll(it) } ?: replaceAll(listOf())
        notifyDataSetChanged()
    }
}

@BindingAdapter("flexibleSizeDetailText")
fun setFlexibleSizeDetailText(view: TextView, content: String?) {
    val length = content?.length ?: 0
    when {
        (length in 0..12) -> {
            view.apply {
                setTextSize(Dimension.SP, 35F)
                text = content
            }
        }
        (length in 13..49) -> {
            view.apply {
                setTextSize(Dimension.SP, 22F)
                text = content
            }
        }
        else -> {
            view.apply {
                setTextSize(Dimension.SP, 16F)
                text = content
            }
        }
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

@BindingAdapter("gradeForProfile")
fun setProfileWithGrade(view: ImageView, code: String?) {
    return when (code) {
        Rating.ASSISTANT_MANAGE.code -> view.context.getDrawable(R.drawable.ic_profile_daeri)
        Rating.DEPARTMENT_HEAD.code -> view.context.getDrawable(R.drawable.ic_profile_bujang)
        Rating.MANAGING_DIRECTOR.code -> view.context.getDrawable(R.drawable.ic_profile_sangmu)
        Rating.BOSS.code -> view.context.getDrawable(R.drawable.ic_profile_sajang)
        else -> view.context.getDrawable(R.drawable.ic_profile_sinip)
    }.let { view.setImageDrawable(it) }
}

@BindingAdapter("textToSend")
fun setCommentSendButton(view: Button, textToSend: String?) {
    view.isEnabled = !textToSend.isNullOrBlank()
}