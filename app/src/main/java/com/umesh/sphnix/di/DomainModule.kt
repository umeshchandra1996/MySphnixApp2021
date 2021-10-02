package com.umesh.sphnix.di

import com.umesh.sphnix.auth.data.repository.AuthRepository
import com.umesh.sphnix.auth.domain.usecase.AuthUseCase
import com.umesh.sphnix.auth.domain.usecase.AuthUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthRepository) =
        AuthUseCaseImpl(repository) as AuthUseCase

}