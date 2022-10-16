package com.itscatalano.capstonenewsapp.networking



import com.itscatalano.capstonenewsapp.models.Article

import com.itscatalano.capstonenewsapp.utils.CustomResult

import java.lang.Exception


const val BASE_URL = "https://newsapi.org/"
const val TOKEN_KEY = "2f8cd5e3444b4e96bc6353df491c8d51"


class RemoteApi(private val apiService: RemoteApiService) {
    suspend fun getArticles() : CustomResult<List<Article>> {
        return  try {
            val data = apiService.getArticles(TOKEN_KEY)
            if (data.articles.isNotEmpty()) {
                CustomResult.Success(data.articles)
            } else {

               CustomResult.Failure("Failed to get article")
            }

        } catch (e: Exception) {
            CustomResult.Failure("errror is ${e.toString()}")
        }
    }
}