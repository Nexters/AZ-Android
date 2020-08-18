package com.az.signup.view.binding

import android.text.Editable
import android.text.TextWatcher
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

@BindingAdapter("blockChangeAfterExistenceCheck")
fun setBlockChange(view: EditText, isValid: Boolean?) {
    if (isValid == true) view.isEnabled = false
}

@BindingAdapter("errorTextVisibility")
fun setErrorTextVisibility(view: TextView, isValid: Boolean?) {
    isValid?.let {
        view.visibility =
            if (it) View.GONE
            else View.VISIBLE
    }
}

@BindingAdapter("passwordChangeListener")
fun setPasswordValidationCheck(view: EditText, passWordCheck: (() -> Unit)?) {
    view.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            passWordCheck?.invoke()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}