package com.az.create

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.Dimension
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

@BindingAdapter("flexibleSizeText")
fun setFlexibleSizeText(view: EditText, text: String?) {
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
    }
}

@BindingAdapter("flexibleSizeTextAttrChanged")
fun setFlexibleSizeTextInverseBindingListener(view: EditText, listener: InverseBindingListener) {
    view.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            listener.onChange()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}

@InverseBindingAdapter(attribute = "flexibleSizeText", event = "flexibleSizeTextAttrChanged")
fun getFlexibleSizeText(view: EditText): String {
    return view.text.toString()
}