package com.offlineapes.lipoapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myWebView = findViewById<WebView>(R.id.myWebView)
        myWebView.settings.javaScriptEnabled = true
        myWebView.addJavascriptInterface(JavaScriptHandler(this), "Android")
        myWebView.settings.setSupportZoom(false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            myWebView.getSettings()
                .setMixedContentMode(
                    WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                );
        }

        myWebView.loadUrl("file:///android_asset/index.html")
    }
}