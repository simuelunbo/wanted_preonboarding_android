package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class SaveNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(news: News) {
        repository.insertLikeNews(news)
    }
}
