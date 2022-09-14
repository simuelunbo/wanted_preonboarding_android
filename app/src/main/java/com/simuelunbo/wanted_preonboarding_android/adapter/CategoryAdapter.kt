package com.simuelunbo.wanted_preonboarding_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simuelunbo.wanted_preonboarding_android.adapter.viewholder.CategoryViewHolder
import com.simuelunbo.wanted_preonboarding_android.databinding.ItemCategoryBinding
import com.simuelunbo.wanted_preonboarding_android.model.Category

class CategoryAdapter(
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryViewHolder>() {
    private val categories = Category.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view, onItemClick)

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(categories[position])


    override fun getItemCount(): Int = categories.count()
}