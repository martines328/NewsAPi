package com.example.newsapi

import android.content.Context
import android.content.Entity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapi.Api.Arcticle
import com.example.newsapi.RoomDB.NewsEntity
import com.example.newsapi.RoomDB.WebView

class Adapter internal constructor(context: Context, newsEntity : List<NewsEntity>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

     var context : Context
    var newsEntityList : List<NewsEntity>



    init {
      this.context  = context

        this.newsEntityList = newsEntity
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.arcticle_recycler_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return newsEntityList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var newsEntity : NewsEntity  = newsEntityList.get(position)
        var urlToImage : String = newsEntity.urlToImage.toString()
        var urlView : String  = newsEntity.urlView.toString()



        holder.title.setText(newsEntity.title)
        holder.author.setText(newsEntity.author)
        holder.description.setText(newsEntity.description)
        holder.name.setText(newsEntity.name)


        Glide.with(context).load(urlToImage).into(holder.imageView)
        holder.view.setOnClickListener({v: View? ->
            var intent = Intent(context, WebView::class.java)
            intent.putExtra("url", urlView)
        })




    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.title_TV)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView_arcticle)
        val description = itemView.findViewById<TextView>(R.id.description_TV)
        val author = itemView.findViewById<TextView>(R.id.author_TV)
        val name = itemView.findViewById<TextView>(R.id.ArcticleName_TV)

        var view = itemView



    }
}