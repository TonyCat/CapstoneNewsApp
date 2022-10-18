package com.itscatalano.capstonenewsapp.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.itscatalano.capstonenewsapp.models.ArticleSource

@Dao
interface ArticleSourceDao {
    // Fetching all the articles that share the same articleTitle
    @Transaction
    @Query("SELECT * FROM articles WHERE title = :articleTitle")
    fun getArticleFromSources(articleTitle: String): ArticleSource

}