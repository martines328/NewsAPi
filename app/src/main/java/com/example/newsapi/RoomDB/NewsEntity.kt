package com.example.newsapi.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "news_table ")
data class NewsEntity(

    @PrimaryKey(autoGenerate = true)
        val id : Int?,

    @ColumnInfo(name = "title")
    val title : String?,

    @ColumnInfo(name = "description")
    val description : String?,

    @ColumnInfo(name = "author")
    val author : String?,

    @ColumnInfo(name = "name")
    val name : String?,

    @ColumnInfo(name = "urlView")
    val urlView : String?,

    @ColumnInfo(name = "urlToImage")
    val urlToImage : String?





 )