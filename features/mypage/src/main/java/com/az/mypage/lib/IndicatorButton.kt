package com.az.mypage.lib

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import androidx.core.view.children
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
            img_indicator.visibility = View.GONE
        }

        txt_label.setTextColor(ContextCompat.getColorStateList(context, R.color.selector_text))

        isClickable = true
        isFocusable = true
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        children.forEach { it.isEnabled = enabled }
    }
}