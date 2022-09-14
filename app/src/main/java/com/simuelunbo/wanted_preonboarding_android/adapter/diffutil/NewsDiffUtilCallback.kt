package com.simuelunbo.wanted_preonboarding_android.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.News

class NewsDiffUtilCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}