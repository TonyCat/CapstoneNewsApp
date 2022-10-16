package com.itscatalano.capstonenewsapp.models.response

import com.itscatalano.capstonenewsapp.models.Article
import com.squareup.moshi.Json

data class GetArticlesResponse(@field:Json(name = "articles") val articles: List<Article> = mutableListOf())