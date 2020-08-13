package com.az.infinite_recyclerview.example

import androidx.recyclerview.widget.RecyclerView
import com.az.infinite_recyclerview.databinding.ItemExampleBinding

class ExampleItemViewHolder(
    private val binding: ItemExampleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ExampleData) {
        with(binding) {
            this.item = item
            executePendingBindings()
        }
    }

}