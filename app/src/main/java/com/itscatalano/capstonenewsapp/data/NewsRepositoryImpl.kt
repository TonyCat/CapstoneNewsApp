package com.itscatalano.capstonenewsapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itscatalano.capstonenewsapp.models.APIresponse
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.net.RetrofitClient
import com.itscatalano.capstonenewsapp.networking.RemoteApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepositoryImpl {

    private val retrofitClient = RetrofitClient()
    private val allNews: LiveData<List<Article>>

    init {
        allNews = getAllNews()
    }


    override fun getAllNews(): LiveData<List<Article>> {

        val data = MutableLiveData<List<Article>>()

        retrofitClient.getNews().enqueue(object : Callback<APIresponse> {
            override fun onFailure(call: Call<APIresponse>, t: Throwable) {
                data.value = null
                Log.d(this.javaClass.simpleName, "Failure")
            }

            override fun onResponse(call: Call<APIresponse>, response: Response<APIresponse>) {
                data.value = response.body()?.articles
                Log.d(this.javaClass.simpleName, "Response: ${response.body()?.articles}")
            }
        })
        return data
    }

}