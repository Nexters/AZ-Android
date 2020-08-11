package com.az.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.az.detail.R
import com.az.detail.adapter.holder.CommentItemViewHolder
import com.az.detail.databinding.ItemCommentsBinding
import com.az.model.posts.detail.comments.CommentData

class CommentsAdapter : RecyclerView.Adapter<CommentItemViewHolder>() {

    private val comments = mutableListOf<CommentData>()

    fun replaceAll(list: List<CommentData>) {
        list.let {
            comments.clear()
            comments.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemCommentsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_comments,
            parent,
            false
        )
        return CommentItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: CommentItemViewHolder, position: Int) {
        holder.bind(comments[position])
    }
}