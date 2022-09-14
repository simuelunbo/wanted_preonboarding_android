package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class DeleteLikeNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(news: News) {
        return repository.deleteLikeNews(news)
    }
}
