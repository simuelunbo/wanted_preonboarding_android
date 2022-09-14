package com.simuelunbo.wanted_preonboarding_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.model.News
import com.simuelunbo.wanted_preonboarding_android.adapter.diffutil.NewsDiffUtilCallback
import com.simuelunbo.wanted_preonboarding_android.adapter.viewholder.NewsViewHolder
import com.simuelunbo.wanted_preonboarding_android.databinding.ItemNewsBinding

class NewsAdapter(
    private val onItemClick: (News) -> Unit,
) : ListAdapter<News, NewsViewHolder>(NewsDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NewsViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}