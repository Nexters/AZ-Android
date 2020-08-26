package com.az.alarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.alarm.R
import com.az.alarm.TempAlarmData
import com.az.alarm.adapter.holder.AlarmItemViewHolder
import com.az.alarm.databinding.ItemAlarmBinding
import com.az.infinite_recyclerview.InfiniteRecyclerview
import com.az.infinite_recyclerview.LoadingViewHolder
import com.az.model.users.notices.DetailedNoticeData

class AlarmsAdapter : InfiniteRecyclerview<DetailedNoticeData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                DataBindingUtil.inflate<ItemAlarmBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_alarm,
                    parent,
                    false
                ).let {
                    AlarmItemViewHolder(it)
                }
            }
            else -> {
                val inflatedView = LayoutInflater
                    .from(parent.context)
                    .inflate(com.az.infinite_recyclerview.R.layout.item_loading, parent, false)
                LoadingViewHolder(inflatedView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_ITEM -> {
                (holder as AlarmItemViewHolder).bind(items[position]!!)
            }
        }
    }
}