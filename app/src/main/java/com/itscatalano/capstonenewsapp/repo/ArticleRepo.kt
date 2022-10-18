package com.itscatalano.capstonenewsapp.repo

import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.models.ArticleSource
import com.itscatalano.capstonenewsapp.models.Source
import com.itscatalano.capstonenewsapp.utils.CustomResult
import kotlinx.coroutines.flow.Flow

interface ArticleRepo {
    suspend fun getArticles(): Flow<CustomResult<List<Article>>>

    suspend fun addArticles(articles: List<Article>)

    suspend fun clearArticles(article: Article)

    suspend fun searchArticles(search: String): List<Article>

    suspend fun getArticleFromSources(articleTitle: String): ArticleSource

    suspend fun getSources(): Source

    suspend fun addSources(source: Source)

    suspend fun clearSources()

}