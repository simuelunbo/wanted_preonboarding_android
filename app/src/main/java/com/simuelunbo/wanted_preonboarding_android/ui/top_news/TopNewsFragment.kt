package com.simuelunbo.wanted_preonboarding_android.ui.top_news

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.simuelunbo.wanted_preonboarding_android.ui.MainViewModel
import com.simuelunbo.wanted_preonboarding_android.R
import com.simuelunbo.wanted_preonboarding_android.adapter.NewsAdapter
import com.simuelunbo.wanted_preonboarding_android.base.BaseFragment
import com.simuelunbo.wanted_preonboarding_android.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopNewsFragment : BaseFragment<FragmentNewsBinding>(R.layout.fragment_news) {
    private val viewModel: MainViewModel by activityViewModels()
    private val adapter: NewsAdapter by lazy {
        NewsAdapter {
            findNavController().navigate(
                TopNewsFragmentDirections.actionTopNewsFragmentToNewsDetailFragment(
                    it
                )
            )
        }
    }

    override fun init() {
        binding.vm = viewModel
        viewModel.updateToolbar(getString(R.string.menu_main_bottom_news))
        viewModelCallback()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rcvTopNews.adapter = adapter
    }

    private fun viewModelCallback() {
        viewModel.topNews.observe(this) {
            adapter.submitList(it)
        }
        viewModel.showToast.observe(this) {
            if (it.consumed) return@observe
            Toast.makeText(context, it.peek(), Toast.LENGTH_SHORT).show()
            it.consume()
        }
    }
}