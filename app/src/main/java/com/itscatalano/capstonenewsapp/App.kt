package com.itscatalano.capstonenewsapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.itscatalano.capstonenewsapp.database.NewsDatabase
import com.itscatalano.capstonenewsapp.networking.NetworkStatusChecker
import com.itscatalano.capstonenewsapp.networking.RemoteApi
import com.itscatalano.capstonenewsapp.networking.buildApiService
import com.itscatalano.capstonenewsapp.repo.ArticleRepo
import com.itscatalano.capstonenewsapp.repo.ArticleRepoImpl
import com.itscatalano.capstonenewsapp.repo.PreferencesDataStoreImpl
import dagger.hilt.android.HiltAndroidApp



private const val KEY_PREFERENCES = "taskie_preferences"
private const val KEY_TOKEN = "token"

@HiltAndroidApp
class App : Application() {
    val dataStore by preferencesDataStore(name = "preferences")

    companion object {
        private lateinit var instance: App

        private val newsDatabase: NewsDatabase by lazy {
            NewsDatabase.buildDatabase(instance)
        }


        private val newsApiService by lazy {
            buildApiService()
        }


        private val networkStatusChecker by lazy {
            NetworkStatusChecker(instance.getSystemService(ConnectivityManager::class.java))
        }


        val gson by lazy{ Gson() }

        val prefsDataStore by lazy { PreferencesDataStoreImpl(instance.dataStore) }

        val newsRepository: ArticleRepo  by lazy {
            ArticleRepoImpl(
                newsDatabase.articleDao(),
                newsDatabase.sourceDao(),
                newsDatabase.articleSourceDao(),
                newsApiService,
                prefsDataStore,
                networkStatusChecker
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}