package com.itscatalano.capstonenewsapp

import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder (
    private val newsView : NewsView
): RecyclerView.ViewHolder(newsView){


    fun bindData(article:Article){
        newsView.setData(article)
    }

}

