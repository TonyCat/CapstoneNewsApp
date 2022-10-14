package com.itscatalano.capstonenewsapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itscatalano.capstonenewsapp.models.Article


@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    suspend fun getArticles(): List<Article>
//    suspend fun getArticles(): List<ArticleAndSource>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticles(articles: List<Article>)

    @Query("DELETE FROM articles")
    suspend fun deleteArticles()
}
