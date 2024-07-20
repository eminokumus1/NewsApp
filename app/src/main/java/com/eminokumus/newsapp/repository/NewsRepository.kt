package com.eminokumus.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.eminokumus.newsapp.Constants
import com.eminokumus.newsapp.api.NewsApiInterface
import com.eminokumus.newsapp.vo.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: NewsApiInterface) {

    fun getAllNews(): LiveData<PagingData<Article>> {
        val config = PagingConfig(Constants.PAGE_SIZE)
        return Pager(config = config,
            pagingSourceFactory = {
                NewsPagingSource(apiService)
            }
        ).liveData
    }
}