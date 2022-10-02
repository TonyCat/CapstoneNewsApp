package com.itscatalano.capstonenewsapp.net

import com.itscatalano.capstonenewsapp.models.APIresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything")
    public fun getNews(@Query("q") qParam: String,
                       @Query("from") fromParam: String,
                       @Query("sortBy") sortByParam: String,
                       @Query("apiKey") apiKeyParam: String,
    ): Call<APIresponse>
}