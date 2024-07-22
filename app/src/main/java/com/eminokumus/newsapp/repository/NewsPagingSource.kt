package com.eminokumus.newsapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eminokumus.newsapp.Constants
import com.eminokumus.newsapp.api.NewsApiInterface
import com.eminokumus.newsapp.vo.Article
import javax.inject.Inject


private var page = Constants.FIRST_PAGE

class NewsPagingSource @Inject constructor(
    private val apiService: NewsApiInterface
) : PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        page = params.key ?: Constants.FIRST_PAGE
        val data =
            apiService.getAllNews("bbc-news", Constants.API_KEY, page, params.loadSize)
        return try {
            if (data.isSuccessful && data.body() != null){
                LoadResult.Page(
                    data = data.body()!!.articles,
                    prevKey = if (page == Constants.FIRST_PAGE) null else page - 1,
                    nextKey = if (data.body()!!.articles.isEmpty()) null else page + 1
                )
            } else {
                throw Exception("Api Service Not Responding")
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}