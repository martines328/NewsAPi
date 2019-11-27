package com.example.newsapi.Api

import com.google.gson.annotations.SerializedName

data class News(

    @SerializedName( "status")
    val status : String,

    @SerializedName( "totalResult")
    val totalResult : String,

    @SerializedName( "articles")
    val arcticles : List<Arcticle>



)