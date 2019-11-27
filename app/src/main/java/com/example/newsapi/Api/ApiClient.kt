package com.example.newsapi.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

companion object{


    val basicApi : String = "https://newsapi.org/v2/"
    lateinit var  retrofit : Retrofit
    val okHttpBuilder = OkHttpClient.Builder()
    
    
    fun getApiClient() : Retrofit = Retrofit.Builder()
                .baseUrl(basicApi)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build()
            
        
    }



}


