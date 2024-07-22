package com.eminokumus.newsapp.di

import com.eminokumus.newsapp.MainActivity
import com.eminokumus.newsapp.details.DetailsFragment
import com.eminokumus.newsapp.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(fragment: NewsFragment)
    fun inject(fragment: DetailsFragment)
    fun inject(activity: MainActivity)

}