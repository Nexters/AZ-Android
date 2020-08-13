package com.az.infinite_recyclerview

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_loading.view.*

class LoadingViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            itemView.progressBar.indeterminateDrawable.colorFilter =
                BlendModeColorFilter(R.color.colorPurple, BlendMode.SRC_ATOP)
        } else {
            itemView.progressBar.indeterminateDrawable.setColorFilter(
                Color.CYAN,
                PorterDuff.Mode.MULTIPLY
            )
        }
    }

}