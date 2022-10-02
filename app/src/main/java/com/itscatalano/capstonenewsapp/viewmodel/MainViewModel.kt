package com.itscatalano.capstonenewsapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.itscatalano.capstonenewsapp.data.NewsRepositoryImpl
import com.itscatalano.capstonenewsapp.models.Article

class MainViewModel(private val repository: NewsRepository = NewsRepositoryImpl()) : ViewModel() {

    private val allNews = MediatorLiveData<List<Article>>()

    init {
        getAllNews()
    }


    private fun getAllNews() {
        allNews.addSource(repository.getAllNews()) { news ->
            allNews.postValue(news)
        }
    }


}