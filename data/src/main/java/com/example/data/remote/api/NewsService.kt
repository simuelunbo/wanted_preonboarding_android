package com.example.data.remote.api

import com.example.data.remote.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsService {

    @GET("top-headlines")
    suspend fun getHeadLineNews(): NewsResponse

    @GET("top-headlines")
    suspend fun getCategoryNews(
        @Query("category") category: String
    ): NewsResponse
}