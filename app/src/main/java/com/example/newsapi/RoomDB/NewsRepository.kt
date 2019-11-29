package com.example.newsapi.RoomDB

import android.content.Context
import com.example.newsapi.LocalDataSource
import org.jetbrains.anko.doAsync

class NewsRepository ( ctx : Context) {

     var  ctx : Context
    lateinit var newsDataBase: NewsDataBase


    init {
        this.ctx = ctx
    }

    fun insertNews ( entity: NewsEntity){

        doAsync {
           newsDataBase.dao().Insert(entity)

        }


    }




    fun getAllNews() : List<NewsEntity>?{

        return newsDataBase.dao().getAll()
    }


}