package com.az.main.view.binding

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.main.R
import com.az.main.adapter.MainHumorsAdapter
import com.az.model.posts.PostData
import com.az.model.users.rating.Rating
import kotlinx.android.synthetic.main.item_humor_card.view.*

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<PostData>?) {
    (view.adapter as? MainHumorsAdapter)?.run {
        items?.let { replaceAll(it) } ?: replaceAll(listOf())
        notifyDataSetChanged()
    }
}

@BindingAdapter("setFame")
fun setFame(view: RecyclerView, b: Boolean?) {
    (view.adapter as? MainHumorsAdapter)?.run {
        b?.let { setIsHumorFame(it) }
        notifyDataSetChanged()
    }
}

@BindingAdapter("conciergeGrade")
fun setConciergeGrade(view: TextView, message: String?) {
    view.text = message?.split("\n")?.first()
}

@BindingAdapter("conciergeMessage")
fun setConciergeMessage(view: TextView, message: String?) {
    view.text = message?.split("\n")?.last()
}

@BindingAdapter("humorGradeProgress")
fun setHumorGradeProgress(view: ProgressBar, progress: Float?) {
    ((progress ?: 0F) * 1000).toInt().let {
        if (it < 1) {
            view.progress = 10
        } else {
            view.progress = it
        }
    }
}

@BindingAdapter("gradeForMainSticker")
fun setMainStickerWithGrade(view: ImageView, code: String?) {
    return when (code) {
        Rating.ASSISTANT_MANAGE.code -> view.context.getDrawable(R.drawable.ic_sticker_main_daeri)
        Rating.DEPARTMENT_HEAD.code -> view.context.getDrawable(R.drawable.ic_sticker_main_bujang)
        Rating.MANAGING_DIRECTOR.code -> view.context.getDrawable(R.drawable.ic_sticker_main_sangmu)
        Rating.BOSS.code -> view.context.getDrawable(R.drawable.ic_sticker_main_sajang)
        else -> view.context.getDrawable(R.drawable.ic_sticker_main_sinip)
    }.let { view.setImageDrawable(it) }
}

@BindingAdapter("grade")
fun setGrade(view: TextView, code: String?) {
    when (code) {
        Rating.ASSISTANT_MANAGE.code -> Rating.ASSISTANT_MANAGE.gradeName
        Rating.DEPARTMENT_HEAD.code -> Rating.DEPARTMENT_HEAD.gradeName
        Rating.MANAGING_DIRECTOR.code -> Rating.MANAGING_DIRECTOR.gradeName
        Rating.BOSS.code -> Rating.BOSS.gradeName
        else -> Rating.NEW_RECRUIT.gradeName
    }.let {
        view.text = it
    }
}

@BindingAdapter("flexibleSizeText")
fun setFlexibleSizeText(view: TextView, text: String?) {
    val length = text?.length ?: 0
    when {
        (length in 0..12) -> {
            view.setTextSize(Dimension.SP, 35F)
        }
        (length in 13..49) -> {
            view.setTextSize(Dimension.SP, 22F)
        }
        else -> {
            view.setTextSize(Dimension.SP, 16F)
        }
    }.also { view.text = text }
}

@BindingAdapter("isFame")
fun setFame(view: ConstraintLayout, isFame: Boolean?) {
    if (isFame != null && isFame) {
        view.let {
            it.background = it.context.getDrawable(R.drawable.bg_humor_card_title_fame)
            it.user_name.setTextColor(getColorInt(it, R.color.colorWhite))
            it.date.setTextColor(getColorInt(it, R.color.colorWhite))
            it.crown.visibility = View.VISIBLE
        }
    } else {
        view.let {
            it.background = it.context.getDrawable(R.drawable.bg_humor_card_title)
            it.user_name.setTextColor(getColorInt(it, R.color.colorSemiBlack))
            it.date.setTextColor(getColorInt(it, R.color.colorSemiBlack))
            it.crown.visibility = View.GONE
        }
    }
}

private fun getColorInt(view: View, colorId: Int): Int {
    return ResourcesCompat.getColor(view.resources, colorId, null)
}