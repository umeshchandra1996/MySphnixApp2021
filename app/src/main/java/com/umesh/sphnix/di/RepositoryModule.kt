package com.umesh.sphnix.di

import com.umesh.sphnix.network.ApiService
import com.umesh.sphnix.auth.data.repository.AuthRepository
import com.umesh.sphnix.auth.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(apiService: ApiService) =
        AuthRepositoryImpl(apiService) as AuthRepository
}