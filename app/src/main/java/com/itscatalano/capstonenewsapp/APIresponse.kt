package com.itscatalano.capstonenewsapp

/***
 * Author: Anthony Catalano
 * Will need this eventually when we connect to the API
 * and based on the status we can display how many articles there are
 * and push the results of the articles in a a list of Article
 *
 */
data class APIresponse(val articles: List<Article>, val status: String, val totalResults: Int)
