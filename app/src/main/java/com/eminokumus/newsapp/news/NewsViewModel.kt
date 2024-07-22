package com.eminokumus.newsapp.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.eminokumus.newsapp.repository.NewsRepository
import com.eminokumus.newsapp.vo.Article
import javax.inject.Inject

class NewsViewModel @Inject constructor (private val repository: NewsRepository): ViewModel() {

    val newsPagingData: LiveData<PagingData<Article>> by lazy {
        repository.getAllNews().cachedIn(viewModelScope)
    }


}