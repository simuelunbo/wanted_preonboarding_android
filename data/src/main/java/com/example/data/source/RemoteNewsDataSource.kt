package com.example.data.source

import com.example.domain.model.News

interface RemoteNewsDataSource {
    suspend fun getHeadLineNews(): List<News>
    suspend fun getCategoryNews(category: String): List<News>
}