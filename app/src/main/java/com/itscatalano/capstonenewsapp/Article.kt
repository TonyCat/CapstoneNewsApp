package com.itscatalano.capstonenewsapp
/***
 * Author: Anthony Catalano
 * Data class to hold the articles
 *
 */
data class Article(val author: String? = null, var title: String , var content: String, var description: String? = null, var publishedAt: String , var source: Source , var url: String , var urlToImage: String? = null )

