package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class GetHeadLineNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): Result<List<News>> = runCatching {
        repository.getHeadLineNews()
    }
}
