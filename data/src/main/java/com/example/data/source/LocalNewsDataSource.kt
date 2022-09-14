package com.example.data.source

import com.example.data.local.entity.NewsEntity
import com.example.domain.model.News

interface LocalNewsDataSource {
    suspend fun getLikeNews(): List<News>
    suspend fun insertLikeNews(news: News)
    suspend fun getCheckLikeNews(title: String): Boolean
    suspend fun deleteLikeNews(news: News)
}