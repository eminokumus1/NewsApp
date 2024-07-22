package com.eminokumus.newsapp.api

import com.eminokumus.newsapp.vo.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET ("top-headlines")
    suspend fun getAllNews(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : Response<NewsResponse>
}