package com.itscatalano.capstonenewsapp.models.response

import com.itscatalano.capstonenewsapp.models.Article

data class GetArticlesResponse(
    val articles: List<Article>,

)