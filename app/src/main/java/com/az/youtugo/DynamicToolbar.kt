package com.az.youtugo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import com.az.core.LoginStatus
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.backspace_toolbar.view.*
import kotlinx.android.synthetic.main.default_toolbar.view.*
import kotlinx.android.synthetic.main.guest_toolbar.view.*
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
    var signUpHandler: (() -> Unit)? = null

    // TODO 모듈에 맞는 툴바 여기에 추가
    // TODO navigation에 label추가하 것
    fun onDestinationChanged(destination: Int, loginStatus: Int) {
        when (destination) {
            R.id.mainFragment -> {
                if (loginStatus == LoginStatus.GUEST_LOGIN.status) {
                    return setLogoGuestToolbar()
                }
                setDefaultToolbar()
            }
            R.id.loginFragment,
            R.id.signupFragment -> setLogoToolbar()
            R.id.forgotPasswordFragment -> setBackspaceToolbar("비밀번호찾기")
            R.id.myPageFragment -> setBackspaceToolbar("마이페이지")
            R.id.alarmFragment -> setBackspaceToolbar("알림")
            R.id.detailsFragment -> setLogoCloseToolbar()
            R.id.createFragment -> setCloseToolbar("개그작성")
            else -> removeAllViews()
        }
    }

    private fun setLogoGuestToolbar() {
        removeAllViews()
        with(getView(R.layout.guest_toolbar)) {
            btn_signUp.setOnClickListener {
                signUpHandler?.invoke()
            }
            addView(this)
        }
    }

    // 로고만 있는 툴바
    private fun setLogoToolbar() {
        removeAllViews()
        with(getView(R.layout.default_toolbar)) {
            layout_default_button_wrap.visibility = View.GONE
            layout_default_delete_button_wrap.visibility = View.GONE
            addView(this)
        }
    }

    // 로고와 알람, 마이페이지 버튼 툴바
    private fun setDefaultToolbar() {
        removeAllViews()
        with(getView(R.layout.default_toolbar)) {
            layout_default_button_wrap.visibility = View.VISIBLE
            layout_default_delete_button_wrap.visibility = View.GONE
            img_alarm.setOnClickListener {
                alarmHandler?.invoke()
            }
            img_my_level.setOnClickListener {
                myPageHandler?.invoke()
            }
            addView(this)
        }
    }

    // 로고와 닫기 버튼 툴바
    private fun setLogoCloseToolbar() {
        removeAllViews()
        with(getView(R.layout.default_toolbar)) {
            layout_default_button_wrap.visibility = View.GONE
            layout_backspace_close_button_wrap.apply {
                visibility = View.GONE
                setOnClickListener {
                    closeHandler?.invoke()
                }
            }
            addView(this)
        }
    }

    // 뒤로가기 버튼 툴바
    private fun setBackspaceToolbar(title: String) {
        removeAllViews()
        with(getView(R.layout.backspace_toolbar)) {
            txt_backspace_title.text = title
            layout_backspace_close_button_wrap.visibility = View.GONE
            img_backspace_back_button.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    backspaceHandler?.invoke()
                }
            }
            addView(this)
        }
    }

    // 타이틀과 닫기 버튼 툴바
    private fun setCloseToolbar(title: String) {
        removeAllViews()
        with(getView(R.layout.backspace_toolbar)) {
            txt_backspace_title.text = title
            img_backspace_back_button.visibility = View.GONE
            layout_backspace_close_button_wrap.apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    closeHandler?.invoke()
                }
            }
            addView(this)
        }
    }

    private fun getView(@LayoutRes layoutId: Int): View {
        return LayoutInflater.from(context).inflate(layoutId, this, false)
    }
}