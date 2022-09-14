package com.example.domain.usecase

import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class GetCheckLocalNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(title: String): Boolean {
        return repository.getCheckLikeNews(title)
    }
}
