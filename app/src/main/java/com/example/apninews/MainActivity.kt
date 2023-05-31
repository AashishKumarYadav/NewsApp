package com.example.apninews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6)

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
        )

        val newsContent = arrayOf(
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content),
            getString(R.string.news_content), getString(R.string.news_content), getString(R.string.news_content)
        )



        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for(i in newsImageArray.indices)
        {
            val news = News(newsHeadingArray[i],newsImageArray[i],newsContent[i])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList,this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity,FullNews::class.java)

                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("image",newsArrayList[position].newsImage)
                intent.putExtra("content",newsArrayList[position].newsContent)
                startActivity(intent)

            }

        })

    }
}