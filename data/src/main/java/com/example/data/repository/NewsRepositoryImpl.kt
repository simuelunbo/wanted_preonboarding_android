package com.example.data.repository

import com.example.data.source.LocalNewsDataSource
import com.example.data.source.RemoteNewsDataSource
import com.example.domain.model.News
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val local : LocalNewsDataSource,
    private val remote : RemoteNewsDataSource
) : NewsRepository {
    override suspend fun getHeadLineNews(): List<News> {
        return remote.getHeadLineNews()
    }

    override suspend fun getCategoryNews(category: String): List<News> {
        return remote.getCategoryNews(category)
    }

    override suspend fun getLikeNews(): List<News> {
        return local.getLikeNews()
    }

    override suspend fun insertLikeNews(news: News) {
        return local.insertLikeNews(news)
    }

    override suspend fun getCheckLikeNews(title: String): Boolean {
        return local.getCheckLikeNews(title)
    }

    override suspend fun deleteLikeNews(news: News) {
        return local.deleteLikeNews(news)
    }
}