package com.itscatalano.capstonenewsapp.networking



import com.itscatalano.capstonenewsapp.models.APIresponse
import com.itscatalano.capstonenewsapp.request.NewsDataRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.itscatalano.capstonenewsapp.App


const val BASE_URL = "https://newsapi.org/"

class RemoteApi(private val apiService: RemoteApiService) {



    fun getNews(onNewsRecieved: () -> Unit) {

        apiService.getNews("Apple", "2022-08-26", "popularity", "2f8cd5e3444b4e96bc6353df491c8d51" ).enqueue(object : Callback<NewsDataRequest> {
            override fun onFailure(call: Call<NewsDataRequest>, error: Throwable) {

            print("*********************** CALL FAILED")

            // onNewsRecieved(emptyList(), error)
            }



            override fun onResponse(
                call: Call<NewsDataRequest>,
                response: Response<NewsDataRequest>
            ) {
                println("****** Recieved response $response")
            }


        })


}

}