package com.example.newsapi

import android.os.AsyncTask
import android.util.Log
import com.example.newsapi.Api.ApiClient
import com.example.newsapi.Api.ApiInterface
import com.example.newsapi.Api.Arcticle
import com.example.newsapi.Api.News
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource : AsyncTask<Void, Void, Void>() {


companion object {
    val apiClient = ApiClient
    lateinit var arcticles: List<Arcticle>
    //var list = arrayListOf<Arcticle>()
}


    override fun doInBackground(vararg params: Void?): Void? {






        Log.d(MainActivity.TAG, "doAsync")

        val apiInterface : ApiInterface = apiClient.getApiClient().create(ApiInterface::class.java)
        val call : Call<News> = apiInterface.getNewsSearch(
            MainActivity.sources,
            MainActivity.apiKey
        )

        call.enqueue(object : Callback<News> {

            override fun onFailure(call: Call<News>, t: Throwable) {


                Log.d(MainActivity.TAG, t.printStackTrace().toString())
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {

                arcticles = response.body()!!.arcticles
                Log.d(MainActivity.TAG, "on Response")

                for (i in arcticles.indices) {
                    var arcticle: Arcticle = arcticles.get(i)
                    var title: String = arcticle.title
                    var author: String = arcticle.author
                    var description: String = arcticle.description
                    var url: String = arcticle.url
                    var urlToImage = arcticle.urlToImage
                    var publishedAt: String = arcticle.publishedAt
                    var content = arcticle.content
                    Log.d(MainActivity.TAG, content)


                }

            }



        })
        return null

    }



}