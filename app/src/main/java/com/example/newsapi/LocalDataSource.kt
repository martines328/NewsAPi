package com.example.newsapi

import android.content.Context
import android.content.Entity
import android.os.AsyncTask
import com.example.newsapi.RoomDB.DAO
import com.example.newsapi.RoomDB.NewsDataBase
import com.example.newsapi.RoomDB.NewsEntity
import org.jetbrains.anko.doAsync

open class LocalDataSource  constructor( title : String,  description : String,  author : String,
                       name : String,  url : String,
                       urlToImage : String ,  context: Context ) :
    AsyncTask<Void, Void, List<NewsEntity>>() {


    private lateinit var dao: DAO


    init {
        var title : String = title
        var description: String = description
        var author:String  = author
        var name : String = name
        var urlToImage: String =  urlToImage
        var context : Context = context
        dao = NewsDataBase.getInstance(context).dao()


    }



    override fun doInBackground(vararg params: Void?): List<NewsEntity>? {





        return null


    }








}