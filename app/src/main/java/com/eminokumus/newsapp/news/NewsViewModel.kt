package com.eminokumus.newsapp.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.eminokumus.newsapp.repository.NewsRepository
import com.eminokumus.newsapp.vo.Article

class NewsViewModel (private val repository: NewsRepository): ViewModel() {

    val newsPagingData: LiveData<PagingData<Article>> by lazy {
        repository.getAllNews()
    }


}