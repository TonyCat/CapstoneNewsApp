package com.itscatalano.capstonenewsapp.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.repo.ArticleRepo
import com.itscatalano.capstonenewsapp.utils.CustomResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class NewsListViewModel(
    private val newsRepo: ArticleRepo
) : ViewModel() {

    class Factory(
        private val newsRepo: ArticleRepo,
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NewsListViewModel(newsRepo) as T
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepo
                .getArticles()
                .onEach { newArticle ->
                    _articles.postValue(newArticle)
                    Log.d("ARTICLE", newArticle.toString())
                }
                .collect()
        }
    }

    fun searchArticles(search: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val filteredArticles = newsRepo.searchArticles("%$search%")
            _articles.postValue(CustomResult.Success(filteredArticles))
        }
    }

    private val _articles = MutableLiveData<CustomResult<List<Article>>>()
    val articles: LiveData<CustomResult<List<Article>>> = _articles

}
