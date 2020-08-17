package com.az.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.infinite_recyclerview.InfiniteRecyclerview
import com.az.infinite_recyclerview.LoadingViewHolder
import com.az.model.BaseDataInterface
import com.az.model.posts.PostData
import com.az.model.posts.detail.comments.CommentData
import com.az.mypage.R
import com.az.mypage.adapter.holder.CommentItemViewHolder
import com.az.mypage.adapter.holder.HumorCardItemViewHolder
import com.az.mypage.adapter.holder.SettingItemViewHolder
import com.az.mypage.adapter.holder.listener.SettingItemListener
import com.az.mypage.databinding.ItemMyCommentBinding
import com.az.mypage.databinding.ItemMyHumorCardBinding
import com.az.mypage.databinding.ItemMySettingBinding
import com.az.mypage.model.MyPageItemCode
import com.az.mypage.model.SettingModel

class MyPageRecyclerViewAdapter(
    private val settingItemListener: SettingItemListener
) : InfiniteRecyclerview<BaseDataInterface>() {

    private var viewType: MyPageItemCode? = null

    fun changeViewType(viewType: MyPageItemCode) {
        this.viewType = viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MyPageItemCode.MY_HUMORS.code,
            MyPageItemCode.MY_BOOKMARKS.code -> {
                val binding = DataBindingUtil.inflate<ItemMyHumorCardBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_my_humor_card,
                    parent,
                    false
                )
                HumorCardItemViewHolder(binding)
            }
            MyPageItemCode.MY_COMMENTS.code -> {
                val binding = DataBindingUtil.inflate<ItemMyCommentBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_my_comment,
                    parent,
                    false
                )
                CommentItemViewHolder(binding)
            }
            MyPageItemCode.SETTING.code -> {
                val binding = DataBindingUtil.inflate<ItemMySettingBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_my_setting,
                    parent,
                    false
                )
                SettingItemViewHolder(binding, settingItemListener)
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
            MyPageItemCode.SETTING.code -> {
                (holder as SettingItemViewHolder).bind(items[position] as SettingModel)
            }
            MyPageItemCode.MY_BOOKMARKS.code,
            MyPageItemCode.MY_HUMORS.code -> {
                (holder as HumorCardItemViewHolder).bind(items[position] as PostData)
            }
            MyPageItemCode.MY_COMMENTS.code -> {
                (holder as CommentItemViewHolder).bind(items[position] as CommentData)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType?.code ?: VIEW_TYPE_LOADING
    }

}
