package com.itscatalano.capstonenewsapp.networking

import com.itscatalano.capstonenewsapp.models.response.GetArticlesResponse
import retrofit2.http.GET

interface NewsApiService {
    @GET("/v2/top-headlines?apiKey=2f8cd5e3444b4e96bc6353df491c8d51&country=US")
    suspend fun getArticles(): GetArticlesResponse
}
