package com.az.signup.view.binding

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.az.signup.R

@BindingAdapter("validationBackground")
fun setValidationBackground(view: EditText, isValid: Boolean?) {
    isValid?.let {
        view.background =
            if (it) view.context.getDrawable(R.drawable.bg_rounded_button_white_border)
            else view.context.getDrawable(R.drawable.bg_rounded_button_red_border)
    }
}

@BindingAdapter("errorTextVisibility")
fun setErrorTextVisibility(view: TextView, isValid: Boolean?) {
    isValid?.let {
        view.visibility =
            if (it) View.GONE
            else View.VISIBLE
    }
}