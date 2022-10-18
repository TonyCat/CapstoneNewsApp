package com.itscatalano.capstonenewsapp

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.views.NewsView
import com.itscatalano.capstonenewsapp.views.NewsViewHolder

class NewsRecyclerAdapter (
    private val onArticleTap: (Article) -> Unit
) :RecyclerView.Adapter<NewsViewHolder>(){

    private var news = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       val newsView = NewsView(parent.context)



        newsView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return NewsViewHolder(newsView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {


        holder.bindData(news[position]){
            onArticleTap(news[position])
        }


    }

    override fun getItemCount(): Int {
        return news.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateArticle(newArticle: List<Article>) {
        news = newArticle.toMutableList()
        notifyDataSetChanged()
    }

}