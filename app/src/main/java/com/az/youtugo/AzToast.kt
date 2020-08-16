package com.az.youtugo

import android.app.Activity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class AzToast(private val activity: Activity) {

    fun showToast(message: String) {
        activity.findViewById<ViewGroup>(R.id.toast_az_container).run {
            activity.layoutInflater
                .inflate(R.layout.toast_az, this)
                .apply { findViewById<TextView>(R.id.text).text = message }
                .let {
                    with(Toast(activity)) {
                        setGravity(Gravity.TOP, 0, 0)
                        duration = Toast.LENGTH_LONG
                        view = it
                        show()
                    }
                }
        }
    }
}