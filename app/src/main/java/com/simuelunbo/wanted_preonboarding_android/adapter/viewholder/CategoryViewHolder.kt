package com.simuelunbo.wanted_preonboarding_android.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.simuelunbo.wanted_preonboarding_android.databinding.ItemCategoryBinding
import com.simuelunbo.wanted_preonboarding_android.model.Category

class CategoryViewHolder(
    private val binding: ItemCategoryBinding,
    onItemClick: (Category) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var category: Category

    init {
        binding.root.setOnClickListener {
            onItemClick(category)
        }
    }

    fun bind(item: Category) {
        category = item
        binding.ivCategory.setImageResource(item.image)
    }
}