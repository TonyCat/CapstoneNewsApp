package com.itscatalano.capstonenewsapp.views

import androidx.recyclerview.widget.RecyclerView
import com.itscatalano.capstonenewsapp.models.Article

class NewsViewHolder (
    private val newsView : NewsView
): RecyclerView.ViewHolder(newsView){


    fun bindData(article: Article, onTap: () -> Unit  ){
        newsView.setData(article)

        newsView.setOnClickListener{
            onTap()
        }
    }

}

