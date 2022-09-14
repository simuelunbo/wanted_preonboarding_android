package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.NewsEntity

@Dao
internal interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(newsEntity: NewsEntity)

    @Query("SELECT * FROM NewsEntity")
    suspend fun getNews(): List<NewsEntity>

    @Query("SELECT * FROM NewsEntity where title = :title")
    suspend fun checkNews(title: String): NewsEntity?

    @Delete
    suspend fun deleteNews(newsEntity: NewsEntity)
}