package com.itscatalano.capstonenewsapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewsRecyclerAdapter (
newsList : List<Article>,
) :RecyclerView.Adapter<NewsViewHolder>(){

    private val news = newsList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       val newsView = NewsView(parent.context)



        newsView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return NewsViewHolder(newsView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       /*holder.bindData(news[position]){
           remove
       }*/

        holder.bindData(news[position])


    }

    override fun getItemCount(): Int {
        return news.size
    }


}