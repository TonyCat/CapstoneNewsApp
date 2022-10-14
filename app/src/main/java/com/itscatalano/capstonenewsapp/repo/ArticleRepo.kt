package com.itscatalano.capstonenewsapp.repo

import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.utils.CustomResult
import kotlinx.coroutines.flow.Flow

interface ArticleRepo {
    fun getArticles(): Flow<CustomResult<List<Article>>>

}