package com.az.mypage.ui.views.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.az.model.BaseDataInterface
import com.az.model.users.rating.Rating
import com.az.mypage.R
import com.az.mypage.adapter.MyPageRecyclerViewAdapter
import com.az.mypage.model.MyPageItemCode

@BindingAdapter("setItems")
fun setItems(view: RecyclerView, items: List<BaseDataInterface>?) {
    (view.adapter as MyPageRecyclerViewAdapter).run {
        items?.let {
            replaceAll(it)
            notifyDataSetChanged()
        } ?: replaceAll(listOf())
    }
}

@BindingAdapter("setViewType")
fun setViewType(view: RecyclerView, viewType: MyPageItemCode) {
    (view.adapter as MyPageRecyclerViewAdapter).run {
        this.changeViewType(viewType)
    }
}

@BindingAdapter("gradeForUserSticker")
fun setUserStickerWithGrade(view: ImageView, code: String?) {
    return when (code) {
        Rating.ASSISTANT_MANAGE.code -> view.context.getDrawable(R.drawable.ic_daeri_full)
        Rating.DEPARTMENT_HEAD.code -> view.context.getDrawable(R.drawable.ic_bujang_full)
        Rating.MANAGING_DIRECTOR.code -> view.context.getDrawable(R.drawable.ic_sangmu_full)
        Rating.BOSS.code -> view.context.getDrawable(R.drawable.ic_sajang_full)
        else -> view.context.getDrawable(R.drawable.ic_sinip_full)
    }.let { view.setImageDrawable(it) }
}