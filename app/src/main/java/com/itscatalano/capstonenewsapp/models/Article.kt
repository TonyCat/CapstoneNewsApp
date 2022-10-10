package com.itscatalano.capstonenewsapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/***
 * Author: Anthony Catalano
 * Data class to hold the articles
 *
 */
@Parcelize
data class Article(val author: String? = null, var title: String?, var content: String?, var description: String? = null, var publishedAt: String?, var source: Source?, var url: String?, var urlToImage: String? = null ) :
    Parcelable

