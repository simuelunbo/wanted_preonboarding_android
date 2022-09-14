package com.example.data.remote.source

import com.example.data.remote.api.NewsService
import com.example.data.source.RemoteNewsDataSource
import com.example.domain.model.News
import javax.inject.Inject

internal class RemoteNewsDataSourceImpl @Inject constructor(
    private val newsService: NewsService
) : RemoteNewsDataSource{
    override suspend fun getHeadLineNews(): List<News> {
        return newsService.getHeadLineNews().articles.map {
            it.convertToNews()
        }
    }

    override suspend fun getCategoryNews(category: String): List<News> {
        return newsService.getCategoryNews(category).articles.map {
            it.convertToNews()
        }
    }
}