package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyRecyclerViewAdapter(private val newsResponse : NewsResponse) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = newsResponse
        holder.bind(news, position)

        holder.itemView.setOnClickListener {
            //test click
            Toast.makeText(holder.view.context, news.articles[position].author, Toast.LENGTH_LONG).show();
            // Navigate to the detail fragment and show the full text of the selected news article
            //val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(news)
            //holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return newsResponse.articles.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    fun bind(newsResponse: NewsResponse, position: Int){
        val category = view.findViewById<TextView>(R.id.item_category)
        val mainText = view.findViewById<TextView>(R.id.item_text)
        val author = view.findViewById<TextView>(R.id.item_author)
        val imageView = view.findViewById<ImageView>(R.id.item_image)
        category.text = newsResponse.articles[position].sourceResponse.name
        mainText.text = newsResponse.articles[position].title
        author.text = newsResponse.articles[position].author
        Picasso.get()
            .load(newsResponse.articles[position].urlToImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(imageView)

    }
}