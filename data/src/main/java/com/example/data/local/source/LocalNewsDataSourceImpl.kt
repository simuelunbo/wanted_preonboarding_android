package com.example.data.local.source

import com.example.data.local.dao.NewsDao
import com.example.data.local.entity.NewsEntity
import com.example.data.source.LocalNewsDataSource
import com.example.domain.model.News
import javax.inject.Inject

internal class LocalNewsDataSourceImpl @Inject constructor(
    private val dao: NewsDao
) : LocalNewsDataSource {
    override suspend fun getLikeNews(): List<News> {
        return dao.getNews().map { it.convertToNews() }
    }

    override suspend fun insertLikeNews(news: News) {
        val newsEntity =
            NewsEntity(
                title = news.title,
                author = news.author,
                description = news.author,
                url = news.author,
                urlToImage = news.urlToImage,
                publishedAt = news.publishedAt,
                content = news.content
            )
        dao.insertNews(newsEntity)
    }

    override suspend fun getCheckLikeNews(title: String): Boolean {
        return dao.checkNews(title) != null
    }

    override suspend fun deleteLikeNews(news: News) {
        val newsEntity =
            NewsEntity(
                title = news.title,
                author = news.author,
                description = news.author,
                url = news.author,
                urlToImage = news.urlToImage,
                publishedAt = news.publishedAt,
                content = news.content
            )
        dao.deleteNews(newsEntity)
    }
}