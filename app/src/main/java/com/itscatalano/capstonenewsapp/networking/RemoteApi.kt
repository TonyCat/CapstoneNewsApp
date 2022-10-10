package com.itscatalano.capstonenewsapp.networking



import com.itscatalano.capstonenewsapp.models.APIresponse
import com.itscatalano.capstonenewsapp.models.Article
import com.itscatalano.capstonenewsapp.request.NewsDataRequest
import com.itscatalano.capstonenewsapp.networking.NetworkStatusChecker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


const val BASE_URL = "https://newsapi.org/"

class RemoteApi(private val apiService: RemoteApiService) {

    suspend fun getNewsSuspend() : Response<APIresponse>{
       return apiService.getNewsSuspend("Apple", "2022-9-05", "popularity", "2f8cd5e3444b4e96bc6353df491c8d51" )
    }


    fun getNews(onNewsRecieved: ( List<Article>,  Throwable?)  -> Unit) {


        apiService.getNews("Apple", "2022-9-05", "popularity", "2f8cd5e3444b4e96bc6353df491c8d51" ).enqueue(object : Callback<APIresponse> {
            override fun onFailure(call: Call<APIresponse>, error: Throwable) {

            print("*********************** CALL FAILED")

             onNewsRecieved(emptyList(), error)
            }



            override fun onResponse(call: Call<APIresponse>, response: Response<APIresponse>) {
                println("****** Recieved response $response")

                println("the articles are ${response.body()}")


                println("**** The actual response code is ${response.code()}")


                println("**** The actual response headers is ${response.headers()}")


                println ("There are ${response.body()!!.articles.size} articles")

                if (response.code() == 200){
                    onNewsRecieved(response.body()!!.articles,null)
                }else{
                   print("It was not a 200 so do nothing")
                }



            }

        })


}

}