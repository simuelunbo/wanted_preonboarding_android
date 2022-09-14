package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.database.NewsLocalDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            NewsLocalDataBase::class.java,
            "news_db"
        ).fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideLocalDao(appDataBase: NewsLocalDataBase) = appDataBase.localDao()
}