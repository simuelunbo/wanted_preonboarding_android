package com.example.data.di

import com.example.data.local.source.LocalNewsDataSourceImpl
import com.example.data.source.LocalNewsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindLocalNewsDataSource(source: LocalNewsDataSourceImpl): LocalNewsDataSource
}