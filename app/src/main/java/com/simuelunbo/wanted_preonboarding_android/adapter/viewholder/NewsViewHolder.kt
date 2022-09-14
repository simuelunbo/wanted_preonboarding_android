package com.simuelunbo.wanted_preonboarding_android.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.News
import com.simuelunbo.wanted_preonboarding_android.databinding.ItemNewsBinding

class NewsViewHolder(
    private val binding: ItemNewsBinding,
    onItemClick: (News) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var news: News

    init {
        binding.root.setOnClickListener {
            onItemClick(news)
        }
    }

    fun bind(news: News) {
        this.news = news
        binding.news = news
        binding.executePendingBindings()
    }
}