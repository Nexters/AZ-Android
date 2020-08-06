package com.az.main.view

import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.model.posts.PostData
import com.az.model.users.rating.Rating

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<PostData>?) {
    (view.adapter as? MainHumorsAdapter)?.run {
        items?.let { replaceAll(it) }
        notifyDataSetChanged()
    }
}

@BindingAdapter("setConciergeGrade")
fun setConciergeGrade(view: TextView, currentRating: String) {
    val conciergeGrade: String = when (currentRating) {
        Rating.ASSISTANT_MANAGE.code -> {
            Rating.ASSISTANT_MANAGE.conciergeGrade
        }
        Rating.DEPARTMENT_HEAD.code -> {
            Rating.DEPARTMENT_HEAD.conciergeGrade
        }
        Rating.MANAGING_DIRECTOR.code -> {
            Rating.MANAGING_DIRECTOR.conciergeGrade
        }
        Rating.BOSS.code -> {
            Rating.BOSS.conciergeGrade
        }
        else -> Rating.NEW_RECRUIT.conciergeGrade
    }
    view.text = conciergeGrade
}

@BindingAdapter("setConciergeMessage")
fun setConciergeMessage(view: TextView, currentRating: String) {
    val conciergeMessage: String = when (currentRating) {
        Rating.ASSISTANT_MANAGE.code -> {
            Rating.ASSISTANT_MANAGE.conciergeMessage
        }
        Rating.DEPARTMENT_HEAD.code -> {
            Rating.DEPARTMENT_HEAD.conciergeMessage
        }
        Rating.MANAGING_DIRECTOR.code -> {
            Rating.MANAGING_DIRECTOR.conciergeMessage
        }
        Rating.BOSS.code -> {
            Rating.BOSS.conciergeMessage
        }
        else -> Rating.NEW_RECRUIT.conciergeMessage
    }
    view.text = conciergeMessage
}

@BindingAdapter(value = ["nextRating", "postCount", "commentCount"], requireAll = true)
fun setHumorGradeProgress(
    view: ProgressBar,
    nextRating: String,
    postCount: Int,
    commentCount: Int
) {
    val postCountForNext: Int
    val commentCountForNext: Int
    when (nextRating) {
        Rating.ASSISTANT_MANAGE.code -> {
            postCountForNext = Rating.ASSISTANT_MANAGE.postCount
            commentCountForNext = Rating.ASSISTANT_MANAGE.commentCount
        }
        Rating.DEPARTMENT_HEAD.code -> {
            postCountForNext = Rating.DEPARTMENT_HEAD.postCount
            commentCountForNext = Rating.DEPARTMENT_HEAD.commentCount
        }
        Rating.MANAGING_DIRECTOR.code -> {
            postCountForNext = Rating.MANAGING_DIRECTOR.postCount
            commentCountForNext = Rating.MANAGING_DIRECTOR.commentCount
        }
        Rating.BOSS.code -> {
            postCountForNext = Rating.BOSS.postCount
            commentCountForNext = Rating.BOSS.commentCount
        }
        else -> {
            postCountForNext = 0
            commentCountForNext = 0
        }
    }
    view.progress =
        getPercentForNextRate(postCountForNext, commentCountForNext, postCount, commentCount)
}

private fun getPercentForNextRate(
    postCountForNext: Int,
    commentCountForNext: Int,
    postCount: Int,
    commentCount: Int
): Int {
    return if (postCountForNext == 0 && commentCountForNext == 0) {
        1000
    } else {
        (postCountForNext + commentCountForNext) * (postCount + commentCount) * 100
    }
}