package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruits : List<Article>,
                            private val clickListener :(Article) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.bind(fruit, clickListener)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    fun bind(article: Article, clickListener :(Article) -> Unit){
        val myTextView = view.findViewById<TextView>(R.id.tvTitle)
        val myAuthor = view.findViewById<TextView>(R.id.textVieAauthor)
        myTextView.text = article.name
        myAuthor.text = article.supplier

        view.setOnClickListener(){
            clickListener(article)
        }
    }
}