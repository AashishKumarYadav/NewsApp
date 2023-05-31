package com.example.apninews

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>,var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    lateinit var myListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.title.text = currentItem.newsHeading
        holder.image.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    class MyViewHolder(itemView : View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.headingTitle)
        val image = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}