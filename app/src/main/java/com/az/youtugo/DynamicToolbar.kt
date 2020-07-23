package com.az.youtugo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.google.android.material.appbar.MaterialToolbar
import org.koin.core.KoinComponent

class DynamicToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : MaterialToolbar(context, attrs, defStyle), KoinComponent {

    var myPageHandler: (() -> Unit)? = null
    var alarmHandler: (() -> Unit)? = null
    var backspaceHandler: (() -> Unit)? = null
    var closeHandler: (() -> Unit)? = null

    // TODO 모듈에 맞는 툴바 여기에 추가
    // TODO navigation에 label추가하 것
    fun onDestinationChanged(destination: Int, destinationName: String?) {
        Log.d("destination", destination.toString())
        when (destination) {
            // R.id.homeFragment -> setDefaultToolbar()
//             R.id.loginFragment -> setLogoToolbar()
            // R.id.alarmFragment -> setBackspaceToolbar()
            R.id.myPageFragment -> setBackspaceToolbar("마이페이지")
            else -> removeAllViews()
        } }

    // 로고만 있는 툴바
    private fun setLogoToolbar() {
        removeAllViews()
        val view = getView(R.layout.default_toolbar)
        val buttonWrap = view.findViewById<LinearLayout>(R.id.layout_default_button_wrap)
        val deleteButton = view.findViewById<LinearLayout>(R.id.layout_default_delete_button_wrap)
        buttonWrap.visibility = View.GONE
        deleteButton.visibility = View.GONE
        addView(view)
    }

    // 로고와 알람, 마이페이지 버튼 툴바
    private fun setDefaultToolbar() {
        removeAllViews()
        val view = getView(R.layout.default_toolbar)
        val buttonWrap = view.findViewById<LinearLayout>(R.id.layout_default_button_wrap)
        val deleteButton = view.findViewById<LinearLayout>(R.id.layout_default_delete_button_wrap)
        val alarmButton = view.findViewById<ImageView>(R.id.img_alarm)
        val myPageButton = view.findViewById<ImageView>(R.id.img_my_level)

        buttonWrap.visibility = View.VISIBLE
        deleteButton.visibility = View.GONE

        alarmButton.setOnClickListener {
            alarmHandler?.invoke()
        }

        myPageButton.setOnClickListener {
            myPageHandler?.invoke()
        }

        addView(view)
    }

    // 로고와 닫기 버튼 툴바
    private fun setLogoCloseToolbar() {
        removeAllViews()
        val view = getView(R.layout.default_toolbar)
        val buttonWrap = view.findViewById<LinearLayout>(R.id.layout_default_button_wrap)
        val closeButton = view.findViewById<LinearLayout>(R.id.layout_default_delete_button_wrap)

        buttonWrap.visibility = View.GONE
        closeButton.visibility = View.VISIBLE

        closeButton.setOnClickListener {
            closeHandler?.invoke()
        }

        addView(view)
    }

    // 뒤로가기 버튼 툴바
    private fun setBackspaceToolbar(title: String) {
        removeAllViews()
        val view = getView(R.layout.backspace_toolbar)
        val txtTitle = view.findViewById<TextView>(R.id.txt_backspace_title)
        val backspaceButton = view.findViewById<ImageView>(R.id.img_backspace_back_button)
        val closeButton = view.findViewById<LinearLayout>(R.id.layout_backspace_delete_button_wrap)

        backspaceButton.visibility = View.VISIBLE
        closeButton.visibility = View.GONE
        txtTitle.text = title

        backspaceButton.setOnClickListener {
            backspaceHandler?.invoke()
        }

        addView(view)
    }

    // 타이틀과 닫기 버튼 툴바
    private fun setCloseToolbar(title: String) {
        removeAllViews()
        val view = getView(R.layout.backspace_toolbar)
        val txtTitle = view.findViewById<TextView>(R.id.txt_backspace_title)
        val backspaceButton = view.findViewById<ImageView>(R.id.img_backspace_back_button)
        val closeButton = view.findViewById<LinearLayout>(R.id.layout_backspace_delete_button_wrap)

        closeButton.visibility = View.VISIBLE
        backspaceButton.visibility = View.GONE
        txtTitle.text = title

        closeButton.setOnClickListener {
            closeHandler?.invoke()
        }

        addView(view)

    }

    private fun getView(@LayoutRes layoutId: Int): View {
        return LayoutInflater.from(context).inflate(layoutId, this, false)
    }
}