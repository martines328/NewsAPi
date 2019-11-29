package com.example.newsapi.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(NewsEntity::class) , version = 1, exportSchema = false)
abstract class NewsDataBase  : RoomDatabase() {

    abstract fun dao() : DAO
    companion object {
        internal val DbName: String = "newsDb"
        fun getInstance(context : Context) : NewsDataBase{

            val  db  = Room.databaseBuilder(context, NewsDataBase::class.java, DbName).build()

            return db


        }



    }



}