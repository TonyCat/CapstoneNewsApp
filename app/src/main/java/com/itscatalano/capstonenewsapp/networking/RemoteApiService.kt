package com.itscatalano.capstonenewsapp.networking

import com.itscatalano.capstonenewsapp.models.APIresponse
import com.itscatalano.capstonenewsapp.models.response.GetArticlesResponse
import com.itscatalano.capstonenewsapp.request.NewsDataRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RemoteApiService {

    @GET("/v2/top-headlines?country=US")
    suspend fun getArticles(@Query("apiKey") token: String): GetArticlesResponse
}