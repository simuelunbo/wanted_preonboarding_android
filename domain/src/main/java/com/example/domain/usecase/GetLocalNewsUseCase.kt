package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class GetLocalNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): List<News> {
        return repository.getLikeNews()
    }
}
