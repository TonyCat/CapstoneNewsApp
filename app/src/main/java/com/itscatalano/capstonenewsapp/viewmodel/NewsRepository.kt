package com.itscatalano.capstonenewsapp.viewmodel

import androidx.lifecycle.LiveData
import com.itscatalano.capstonenewsapp.models.Article

class NewsRepository {

    fun getAllNews(): LiveData<List<Article>>


}