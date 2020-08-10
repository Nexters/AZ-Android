package com.az.mypage.lib

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import com.az.mypage.R
import kotlinx.android.synthetic.main.indicator_button.view.*

@Suppress("LeakingThis")
open class IndicatorButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.indicator_button, this, true)

        context.theme.obtainStyledAttributes(attrs, R.styleable.IndicatorButton, 0, 0).use {
            isEnabled = it.getBoolean(R.styleable.IndicatorButton_android_enabled, isEnabled)
            img_icon.setImageDrawable(it.getDrawable(R.styleable.IndicatorButton_icon))
            txt_label.text = it.getText(R.styleable.IndicatorButton_android_text)
        }

        img_icon.imageTintList = ContextCompat.getColorStateList(context, R.color.colorGray)
        img_indicator.imageTintList = ContextCompat.getColorStateList(context, R.color.colorGray)
        txt_label.setTextColor(ContextCompat.getColorStateList(context, R.color.colorGray))

        isClickable = true
        isFocusable = true
    }
}