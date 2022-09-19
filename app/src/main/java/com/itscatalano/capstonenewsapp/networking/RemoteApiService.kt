package com.itscatalano.capstonenewsapp.networking

import com.itscatalano.capstonenewsapp.request.NewsDataRequest
import retrofit2.Call
import retrofit2.http.*

interface RemoteApiService {


    @GET("v2/everything")
    public fun getNews(@Query("q") qParam: String,
                       @Query("from") fromParam: String ,
                       @Query("sortBy") sortByParam: String ,
                       @Query("apiKey") apiKeyParam: String ,
    ): Call<NewsDataRequest>

//fun getNews(@Query("q") String Qparam ): Call<NewsDataRequest>

/*
    @POST("/api/register")
    fun registerUser(@Body request: UserDataRequest): Call<RegisterResponse>

    @GET("/api/note")
    fun getNotes(@Header("Authorization") token: String): Call<GetTasksResponse>

    @POST("/api/login")
    fun loginUser(@Body request: UserDataRequest): Call<LoginResponse>

    @GET("/api/user/profile")
    fun getMyProfile(@Header("Authorization") token: String): Call<UserProfileResponse>

    @POST("/api/note/complete")
    fun completeTask(
        @Header("Authorization") token: String,
        @Query("id") noteId: String): Call<CompleteNoteResponse>

    @POST("/api/note")
    fun addTask(
        @Header("Authorization") token: String,
        @Body request: AddTaskRequest): Call<Task>

*/

}