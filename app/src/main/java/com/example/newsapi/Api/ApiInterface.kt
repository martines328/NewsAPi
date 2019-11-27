package com.example.newsapi.Api

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    
    @GET("top-headlines")
    fun getNewsSearch(
    
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String ): retrofit2.Call<News>
    
    
    
    
    
}