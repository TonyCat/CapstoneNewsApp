package com.itscatalano.capstonenewsapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.itscatalano.capstonenewsapp.databinding.ActivityMainBinding
import com.itscatalano.capstonenewsapp.networking.NetworkStatusChecker
import com.itscatalano.capstonenewsapp.request.NewsDataRequest
import com.itscatalano.capstonenewsapp.views.NewsDetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var newsRecyclerView: RecyclerView


    private val remoteApi = App.remoteApi

    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }


    companion object {
        const val LIST_DETAIL_REQUEST_CODE = 123
        const val INTENT_LIST_KEY = "key"
    }


    private val authenticationHeaders = mapOf(
        "API_KEY" to "sdfvwefrgvqw3ervwervwervwefv",
        "Authorization" to "auth token",
        "content/type" to "application/json"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)





        networkStatusChecker.performIfConnectedToInternet {
            remoteApi.getNews { articles, error ->
               // binding.newsRecyclerView.run {   ///if you needed to do multiple things on the recycler view

                    if (error != null) {
                        println("My error is $error.message")
                    } else {


                                binding.newsRecyclerView.adapter =
                                    NewsRecyclerAdapter(articles) { articleIndex ->
                                        val newsDetailIntent =
                                            Intent(
                                                this@MainActivity,
                                                NewsDetailActivity::class.java
                                            )
                                        newsDetailIntent.putExtra("article", articles[articleIndex])
                                        startActivity(newsDetailIntent)


                                    }



                    }
              //  }
            }
        }


    }

    private fun fetchData(): String? {
        for (value in authenticationHeaders.values) {
            println(value)
        }
        return authenticationHeaders["API_KEY"]
    }


}







