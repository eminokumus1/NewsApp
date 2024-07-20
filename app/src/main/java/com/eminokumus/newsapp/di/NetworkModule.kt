package com.eminokumus.newsapp.di

import com.eminokumus.newsapp.Constants
import com.eminokumus.newsapp.api.NewsApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
class NetworkModule {



    @Singleton
    @Provides
    fun provideNewsApiService(): NewsApiInterface{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiInterface::class.java)
    }
}