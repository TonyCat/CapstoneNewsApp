package com.itscatalano.capstonenewsapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.itscatalano.capstonenewsapp.App.Companion.newsRepository
import com.itscatalano.capstonenewsapp.databinding.ActivityMainBinding
import com.itscatalano.capstonenewsapp.networking.NetworkStatusChecker
import com.itscatalano.capstonenewsapp.networking.NewsApiService
import com.itscatalano.capstonenewsapp.networking.RemoteApiService
import com.itscatalano.capstonenewsapp.request.NewsDataRequest
import com.itscatalano.capstonenewsapp.utils.CustomResult
import com.itscatalano.capstonenewsapp.viewmodels.MainActivityViewModel
import com.itscatalano.capstonenewsapp.viewmodels.NewsListViewModel
import com.itscatalano.capstonenewsapp.views.NewsDetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

   // private lateinit var newsRecyclerView: RecyclerView

    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModel.Factory()
    }

   // private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModel.Factory }

//    private val viewsModel by viewModels<NewsListViewModel> {
//        NewsListViewModel.Factory(
//            newsRepo = App.newsRepository
//        )
//    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.articleRecyclerView.run {
            adapter = articleAdapter

        }

        viewsModel.articles.observe(this) { result ->
            when(result) {
                is CustomResult.Success -> {
                    articleAdapter.updateArticle(result.value)
                }
                is CustomResult.Failure -> {
                    Toast.makeText(this@MainActivity, "No Data Available", Toast.LENGTH_LONG).show()
                }
            }
       //     Toast.makeText(this@MainActivity, "Refresh true", Toast.LENGTH_LONG).show()
            binding.swiperefresh.isRefreshing = false
        }

        //fetchArticles()

/*
        val queryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchQuery ->
                    viewsModel.searchArticles(searchQuery)
                }
                return true
            }

        }
*/
        //   binding.searchView.setOnQueryTextListener(queryTextListener)



//        binding.swiperefresh.setOnRefreshListener {
//            fetchArticles()
//        }

    }



    private val viewsModel by viewModels<NewsListViewModel> {
        NewsListViewModel.Factory(
            newsRepo = App.newsRepository
        )
    }

    private val articleAdapter =
        NewsRecyclerAdapter{ article ->
            val newsDetailIntent = Intent(this@MainActivity, NewsDetailActivity::class.java)
            newsDetailIntent.putExtra(INTENT_EXTRA_ARTICLE, article)
            startActivity(newsDetailIntent)
        }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val switchItem = menu!!.findItem(R.id.custom_menu_items)
        val switch = switchItem.actionView?.findViewById<SwitchCompat>(R.id.wifi_switch)
        viewModel.isDownloadOverWifiOnly.observe(this) { isDownloadOverWifiOnly ->
            if (switch != null) {
                isDownloadOverWifiOnly.also { switch.isChecked = it }
            }
            if (isDownloadOverWifiOnly) {
                if (switch != null) {
                    switch.text = getString(R.string.switch_on, switchItem.title)
                }
            } else {
                if (switch != null) {
                    switch.text = getString(R.string.switch_off, switchItem.title)
                }
            }
        }
        switch?.setOnCheckedChangeListener { _, _ ->
            viewModel.toggleDownloadOverWifiOnly()

        }
        return true
    }


    companion object {
        const val INTENT_EXTRA_ARTICLE = "article"
    }

    private fun fetchArticles() {

        binding.swiperefresh.isRefreshing = true

     viewsModel.fetchArticles()

    }

}





