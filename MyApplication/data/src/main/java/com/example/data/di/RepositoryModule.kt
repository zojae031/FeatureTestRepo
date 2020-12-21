package com.example.data.di

import com.example.data.BooksRepositoryImpl
import com.example.data.service.BooksService
import com.example.domain.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(booksService: BooksService): BooksRepository =
        BooksRepositoryImpl(booksService)

    @Provides
    @Singleton
    fun provideBooksApi(retrofit: Retrofit): BooksService =
        retrofit.create(BooksService::class.java)

    @Provides
    fun provideBaseUrl(): String = "https://api.itbook.store/1.0/"

    @Provides
    @Singleton
    fun provideRetrofit2(okHttpClient: OkHttpClient, baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .readTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .build()
    }


}