package com.sofascore.results

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        val toggleButton = findViewById<SwitchCompat>(R.id.toggle)
        val webView = findViewById<WebView>(R.id.web_view)
        toggleButton.setOnCheckedChangeListener { _, turnOn ->
            if (turnOn) {
                webView.pauseTimers()
            } else {
                webView.resumeTimers()
            }
        }

    }

}