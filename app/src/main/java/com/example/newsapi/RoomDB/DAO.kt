package com.example.newsapi.RoomDB

import androidx.room.*

@Dao
open interface DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Insert(entity: NewsEntity) : Void?


    @Query("SELECT * FROM `news_table `")
    fun getAll() : List<NewsEntity>?

    @Update
    fun update(entity: NewsEntity)

}