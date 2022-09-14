package com.simuelunbo.wanted_preonboarding_android.ui.detail

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.simuelunbo.wanted_preonboarding_android.ui.MainViewModel
import com.simuelunbo.wanted_preonboarding_android.R
import com.simuelunbo.wanted_preonboarding_android.base.BaseFragment
import com.simuelunbo.wanted_preonboarding_android.databinding.FragmentNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(R.layout.fragment_news_detail) {
    private val viewModel: MainViewModel by activityViewModels()
    private val args: NewsDetailFragmentArgs by navArgs()


    override fun init() {
        binding.vm = viewModel
        initState()
        viewModelCallback()
    }

    private fun viewModelCallback() {
        viewModel.isStar.observe(this) {
            changeStarImage(it)
        }
    }

    private fun changeStarImage(isStar: Boolean) {
        if(isStar) {
            binding.ivStar.setImageResource(R.drawable.ic_full_star)
        } else {
            binding.ivStar.setImageResource(R.drawable.ic_empty_star)
        }
    }

    private fun initState() {
        viewModel.updateToolbar(args.news.title)
        viewModel.setDetailNews(args.news)
        viewModel.checkIsSaved()
    }




}