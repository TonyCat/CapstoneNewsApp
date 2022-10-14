package com.itscatalano.capstonenewsapp

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.itscatalano.capstonenewsapp.database.NewsDatabase
import com.itscatalano.capstonenewsapp.networking.RemoteApi
import com.itscatalano.capstonenewsapp.networking.buildApiService
import com.itscatalano.capstonenewsapp.repo.ArticleRepo
import com.itscatalano.capstonenewsapp.repo.ArticleRepoImpl

private const val KEY_PREFERENCES = "taskie_preferences"
private const val KEY_TOKEN = "token"

class App : Application() {

    companion object {
        private lateinit var instance: App

        val gson = Gson()

        private val preferences by lazy {
            instance.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE)
        }

        private val newsDatabase: NewsDatabase by lazy {
            NewsDatabase.buildDatabase(instance)
        }
        private val newsApiService by lazy {
            buildApiService()
        }

        val articleRepo: ArticleRepo by lazy {
            ArticleRepoImpl(newsDatabase.articleDao(), newsDatabase.sourceDao(), newsApiService)
        }

        fun saveToken(token: String) {
            preferences.edit()
                .putString(KEY_TOKEN, token)
                .apply()
        }

        fun getToken() = preferences.getString(KEY_TOKEN, "") ?: ""

        private val apiService by lazy { buildApiService() }

        val remoteApi by lazy { RemoteApi(apiService) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}