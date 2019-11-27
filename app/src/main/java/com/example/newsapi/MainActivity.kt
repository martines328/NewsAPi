package com.example.newsapi

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.newsapi.Api.ApiClient
import com.example.newsapi.Api.ApiInterface
import com.example.newsapi.Api.Arcticle
import com.example.newsapi.Api.News
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    companion object{

        val sources : String = "techcrunch"
        val apiKey : String = "156885bf94af406cbe310eb5ef39d6da"
        val TAG : String = "mytag"



    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d(TAG, "oncreate")
        getNews()

    }




    fun getNews() {

        val apiClient = ApiClient
        var arcticles : List<Arcticle>
        Log.d(TAG, "getNews")
        
        doAsync {

            Log.d(TAG, "doAsync")

            val apiInterface : ApiInterface = apiClient.getApiClient().create(ApiInterface::class.java)
            val call : Call<News> = apiInterface.getNewsSearch(sources, apiKey)

            call.enqueue(object : Callback<News>{

                override fun onFailure(call: Call<News>, t: Throwable) {
                
                    toast("Please choose your request")
                    Log.d(TAG, "onfailure")
                }

                override fun onResponse(call: Call<News>, response: Response<News>) {
                
                    arcticles = response.body()!!.arcticles
                    Log.d(TAG, "on Response")
                    
                    for ( i in arcticles){
                        var arcticle : Arcticle = arcticles.get(5)
                        var title : String = arcticle.title
                        Log.d(TAG, title)




                    }
                
                
                }
            })
            



            



        }
        
        


    }



}
