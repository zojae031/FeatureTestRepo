package com.example.coroutinetest.di

import com.example.domain.repository.Repository
import com.example.domain.usecase.ApiUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideUseCase(repository: Repository): UseCase = ApiUseCase(repository)
}

