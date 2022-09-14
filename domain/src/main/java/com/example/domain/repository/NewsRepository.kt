package com.example.domain.repository

import com.example.domain.model.News

interface NewsRepository {
    suspend fun getHeadLineNews(): List<News>
    suspend fun getCategoryNews(category: String): List<News>
    suspend fun getLikeNews(): List<News>
    suspend fun insertLikeNews(news: News)
    suspend fun getCheckLikeNews(title: String): Boolean
    suspend fun deleteLikeNews(news: News)
}