package com.example.data.di

import com.example.data.remote.source.RemoteNewsDataSourceImpl
import com.example.data.source.RemoteNewsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteNewsDataSource(source: RemoteNewsDataSourceImpl): RemoteNewsDataSource
}