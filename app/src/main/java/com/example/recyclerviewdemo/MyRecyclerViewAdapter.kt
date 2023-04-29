package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val articleResponses : List<ArticleResponse>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = articleResponses[position]
    }

    override fun getItemCount(): Int {
        return articleResponses.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    fun bind(articleResponse: ArticleResponse){
        val category = view.findViewById<TextView>(R.id.item_category)
        val mainText = view.findViewById<TextView>(R.id.item_text)
        val author = view.findViewById<TextView>(R.id.item_author)
        category.text = articleResponse.title
        mainText.text = articleResponse.content
        author.text = articleResponse.author

    }
}