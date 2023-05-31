package com.example.apninews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FullNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_news)


        val heading = intent.getStringExtra("heading")
        val image = intent.getIntExtra("image",R.drawable.img1)
        val content = intent.getStringExtra("content")

        val headingTV = findViewById<TextView>(R.id.newsHeading)
        val imageIV = findViewById<ImageView>(R.id.newsImage)
        val contentTV = findViewById<TextView>(R.id.newsContent)

        headingTV.text = heading
        contentTV.text = content
        imageIV.setImageResource(image)
    }
}