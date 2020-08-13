package com.az.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.infinite_recyclerview.InfiniteRecyclerview
import com.az.infinite_recyclerview.LoadingViewHolder
import com.az.main.R
import com.az.main.adapter.holder.MainHumorItemViewHolder
import com.az.main.adapter.holder.listener.HumorItemListener
import com.az.main.databinding.ItemHumorCardBinding
import com.az.model.posts.PostData

class MainHumorsAdapter(
    private val listener: HumorItemListener
) : InfiniteRecyclerview<PostData>() {

    private var isFame: Boolean = false

    fun setIsHumorFame(b: Boolean) {
        isFame = b
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                DataBindingUtil.inflate<ItemHumorCardBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_humor_card,
                    parent,
                    false
                ).let {
                    MainHumorItemViewHolder(it, listener)
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
                (holder as MainHumorItemViewHolder).bind(items[position]!!, isFame)
            }
        }
    }
}