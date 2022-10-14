package com.itscatalano.capstonenewsapp.models

import android.os.Parcelable
import androidx.room.*
import com.itscatalano.capstonenewsapp.database.converters.SourceConverter
import kotlinx.parcelize.Parcelize

/***
 * Author: Anthony Catalano
 * Data class to hold the articles
 *
 */
@Parcelize
@Entity(tableName="articles")
data class Article(
    val author: String? = null,
    @PrimaryKey
    var title: String,
    var content: String?  = null,
    var description: String? = null,
    var publishedAt: String? = null,
   // @TypeConverters(SourceConverter::class)
    val source: Source,
    var url: String? = null,
    var urlToImage: String? = null) :
    Parcelable

