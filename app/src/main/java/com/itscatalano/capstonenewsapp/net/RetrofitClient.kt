package com.itscatalano.capstonenewsapp.net

import com.itscatalano.capstonenewsapp.models.APIresponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val newsApi: NewsApi

    companion object {
        private const val API_KEY = "2f8cd5e3444b4e96bc6353df491c8d51"
        private const val TMDB_BASE_URL = "https://newsapi.org/"
        private const val SORT_BY = "popularity"
        private const val FROMPARAM = "2022-9-01"
        private const val QPARAM = "Apple"
    }

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        newsApi = retrofit.create(NewsApi::class.java)
    }

    fun getNews(query: String): Call<APIresponse> {
        return newsApi.getNews(QPARAM, FROMPARAM, SORT_BY, API_KEY)
    }

}