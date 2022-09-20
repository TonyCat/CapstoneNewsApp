package com.itscatalano.capstonenewsapp.models.response

import com.itscatalano.capstonenewsapp.models.Article
import com.squareup.moshi.Json

/***
 * Author: Anthony Catalano
 * Will need this eventually when we connect to the API
 * and based on the status we can display how many articles there are
 * and push the results of the articles in a a list of Article
 *
 */

class APIresponse(
    @field:Json(name = "articles") val articles: List<Article>,
    @field:Json(name = "status") val status: String?,
    @field:Json(name = "totalResults") val totalResults: Int?)