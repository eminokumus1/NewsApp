package com.eminokumus.newsapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.eminokumus.newsapp.databinding.ItemNewsBinding
import com.eminokumus.newsapp.vo.Article

class NewsAdapter(var onNewsItemClickListener: OnNewsItemClickListener) :
    PagingDataAdapter<Article, NewsAdapter.NewsViewHolder>(NewsDiffCallBack) {
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article, onNewsItemClickListener)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context))
        return NewsViewHolder(binding)
    }

    object NewsDiffCallBack : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    class NewsViewHolder(var binding: ItemNewsBinding) : ViewHolder(binding.root) {
        fun bind(article: Article?, onNewsItemClickListener: OnNewsItemClickListener) {
            binding.newsTitle.text = article?.title

            Glide.with(binding.root)
                .load(article?.urlToImage)
                .into(binding.newsImage)

            binding.root.setOnClickListener {
                onNewsItemClickListener.onNewsItemClick(article)
            }
        }
    }


}