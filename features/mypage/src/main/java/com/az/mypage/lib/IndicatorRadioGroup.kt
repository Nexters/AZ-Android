package com.az.mypage.lib

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.core.view.children

class IndicatorRadioGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var checkedId = View.NO_ID
    private var protectFromCheckedChange = false

    private var passThroughListener: PassThroughHierarchyChangeListener? = null
    private var childOnCheckedChangeListener: CheckableIndicatorButton.OnCheckedChangeListener? = null

    init {
        childOnCheckedChangeListener = CheckedStateTracker()
        passThroughListener = PassThroughHierarchyChangeListener()

        super.setOnHierarchyChangeListener(passThroughListener)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if (child is IndicatorRadioButton) {
            if (child.isChecked) {
                protectFromCheckedChange = true
                if (checkedId != View.NO_ID) {
                    setCheckedStateForView(checkedId, false)
                }
                protectFromCheckedChange = false
                setCheckedId(child.id)
            }
        }

        super.addView(child, index, params)
    }

    override fun setOnHierarchyChangeListener(listener: OnHierarchyChangeListener) {
        passThroughListener?.onHierarchyChangeListener = listener
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (checkedId != View.NO_ID) {
            protectFromCheckedChange = true
            setCheckedStateForView(checkedId, true)
            protectFromCheckedChange = false
            setCheckedId(checkedId)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        children.forEach { it.isEnabled = enabled }
    }

    private fun setCheckedStateForView(viewId: Int, checked: Boolean) {
        val checkedView = findViewById<View>(viewId)
        if (checkedView != null && checkedView is IndicatorRadioButton) {
            checkedView.isChecked = checked
        }
    }

    private fun setCheckedId(@IdRes id: Int) {
        checkedId = id
    }

    private inner class CheckedStateTracker : CheckableIndicatorButton.OnCheckedChangeListener {
        override fun onCheckedChanged(view: View, isChecked: Boolean) {
            if (protectFromCheckedChange) {
                return
            }

            protectFromCheckedChange = true
            if (checkedId != View.NO_ID) {
                setCheckedStateForView(checkedId, false)
            }
            protectFromCheckedChange = false

            val id = view.id
            setCheckedId(id)
        }
    }

    private inner class PassThroughHierarchyChangeListener : OnHierarchyChangeListener {
        var onHierarchyChangeListener: OnHierarchyChangeListener? = null

        override fun onChildViewAdded(parent: View, child: View) {
            if (parent === this@IndicatorRadioGroup && child is IndicatorRadioButton) {
                var id = child.id
                if (id == View.NO_ID) {
                    id = View.generateViewId()
                    child.id = id
                }
                childOnCheckedChangeListener?.let {
                    child.addOnCheckChangeListener(it)
                }
            }

            onHierarchyChangeListener?.onChildViewAdded(parent, child)
        }

        override fun onChildViewRemoved(parent: View, child: View) {
            if (parent === this@IndicatorRadioGroup && child is IndicatorRadioButton) {
                childOnCheckedChangeListener?.let {
                    child.removeOnCheckChangeListener(it)
                }
            }
            onHierarchyChangeListener?.onChildViewRemoved(parent, child)
        }
    }
}