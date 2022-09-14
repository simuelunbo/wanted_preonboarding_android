package com.simuelunbo.wanted_preonboarding_android.ui.category

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.simuelunbo.wanted_preonboarding_android.ui.MainViewModel
import com.simuelunbo.wanted_preonboarding_android.R
import com.simuelunbo.wanted_preonboarding_android.adapter.CategoryAdapter
import com.simuelunbo.wanted_preonboarding_android.base.BaseFragment
import com.simuelunbo.wanted_preonboarding_android.databinding.FragmentCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>(R.layout.fragment_categories) {
    private val viewModel: MainViewModel by activityViewModels()
    private val adapter: CategoryAdapter = CategoryAdapter { category ->
        findNavController().navigate(
            CategoriesFragmentDirections.actionCategoriesFragmentToCategoryNewsFragment(
                category.name.lowercase().replaceFirstChar {
                    it.uppercase()
                })
        )
    }

    override fun init() {
        binding.vm = viewModel
        viewModel.updateToolbar(getString(R.string.menu_main_bottom_category))
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.rcvCategory.adapter = adapter
    }

}