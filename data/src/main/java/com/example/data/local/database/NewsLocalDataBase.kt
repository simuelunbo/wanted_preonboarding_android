package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.NewsDao
import com.example.data.local.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
internal abstract class NewsLocalDataBase : RoomDatabase() {
    abstract fun localDao(): NewsDao
}