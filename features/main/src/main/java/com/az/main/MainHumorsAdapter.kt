package com.az.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.main.databinding.ItemHumorCardBinding

class MainHumorsAdapter : RecyclerView.Adapter<MainHumorItemViewHolder>() {

    private val humors = mutableListOf<TempHumorData>()

    fun replaceAll(list: List<TempHumorData>) {
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
        holder.bind(humors[position])
    }
}