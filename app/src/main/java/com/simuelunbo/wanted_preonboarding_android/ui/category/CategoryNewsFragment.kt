package com.simuelunbo.wanted_preonboarding_android.ui.category

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.simuelunbo.wanted_preonboarding_android.ui.MainViewModel
import com.simuelunbo.wanted_preonboarding_android.R
import com.simuelunbo.wanted_preonboarding_android.adapter.NewsAdapter
import com.simuelunbo.wanted_preonboarding_android.base.BaseFragment
import com.simuelunbo.wanted_preonboarding_android.databinding.FragmentCategoryNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryNewsFragment :
    BaseFragment<FragmentCategoryNewsBinding>(R.layout.fragment_category_news) {
    private val viewModel: MainViewModel by activityViewModels()
    private val args: CategoryNewsFragmentArgs by navArgs()

    private val adapter: NewsAdapter by lazy {
        NewsAdapter {
            findNavController().navigate(
                CategoryNewsFragmentDirections.actionCategoryNewsFragmentToNewsDetailFragment(
                    it
                )
            )
        }
    }

    override fun init() {
        binding.vm = viewModel
        viewModel.setCategory(args.category)
        viewModel.updateToolbar(getString(R.string.category_news_toolbar_title, args.category))
        viewModelCallback()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rcvCategoryNewsList.adapter = adapter
    }

    private fun viewModelCallback() {
        viewModel.categoryNews.observe(this) {
            adapter.submitList(it)
        }
        viewModel.showToast.observe(this) {
            if (it.consumed) return@observe
            Toast.makeText(context, it.peek(), Toast.LENGTH_SHORT).show()
            it.consume()
        }
    }
}