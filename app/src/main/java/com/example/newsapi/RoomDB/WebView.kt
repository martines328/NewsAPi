
package com.example.newsapi.RoomDB

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import com.example.newsapi.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val  intent : Intent = getIntent()
        val url : String = intent.getStringExtra("url")
        val webSettings : WebSettings = webView.settings
        webSettings.loadsImagesAutomatically
        webSettings.javaScriptEnabled
        webSettings.setSupportZoom(true)
        webView.loadUrl(url)



    }
}
