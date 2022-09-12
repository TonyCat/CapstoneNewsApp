package com.itscatalano.capstonenewsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itscatalano.capstonenewsapp.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var newsRecyclerView: RecyclerView


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


        var count = 0

        var allArticles = NewsService().getAllArticles()


        //first check to see if there is anydata stored in the newsDataManager with readNews
        val newsDataManager = NewsDataManager(this)

        var newsFromMemory = newsDataManager.readNews()

        if (newsFromMemory.isEmpty()) {
            newsDataManager.saveNews(allArticles)
            newsFromMemory = newsDataManager.readNews()
        }




        binding.newsRecyclerView.run {
            adapter = NewsRecyclerAdapter(newsFromMemory) { articleIndex ->
                val newsDetailIntent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                newsDetailIntent.putExtra("article", newsFromMemory[articleIndex])
                startActivity(newsDetailIntent)
            }
        }

        println("Fetching data with API KEY ${fetchData()}")


    }


    private fun fetchData(): String? {
        for (value in authenticationHeaders.values) {
            println(value)
        }
        return authenticationHeaders["API_KEY"]
    }


}







