package com.eminokumus.newsapp

import android.app.Application
import com.eminokumus.newsapp.di.AppComponent
import com.eminokumus.newsapp.di.DaggerAppComponent
import com.eminokumus.newsapp.news.NewsFragment

class MyApplication: Application() {

    val appComponent: AppComponent by lazy{
        DaggerAppComponent.create()
    }


}