package com.az.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.main.R
import com.az.main.databinding.ItemHumorCardBinding
import com.az.model.posts.PostData

class MainHumorsAdapter : RecyclerView.Adapter<MainHumorItemViewHolder>() {

    private val humors = mutableListOf<PostData>()
    private var isFame: Boolean = false

    fun setIsHumorFame(b: Boolean) {
        isFame = b
    }

    fun replaceAll(list: List<PostData>) {
        list.let {
            humors.clear()
            humors.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHumorItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemHumorCardBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_humor_card,
            parent,
            false
        )
        return MainHumorItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return humors.size
    }

    override fun onBindViewHolder(holder: MainHumorItemViewHolder, position: Int) {
        holder.bind(humors[position], isFame)
    }
}