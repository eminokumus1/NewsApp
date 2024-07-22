package com.eminokumus.newsapp.news

import com.eminokumus.newsapp.vo.Article

interface OnNewsItemClickListener {
    fun onNewsItemClick(article: Article?)
}