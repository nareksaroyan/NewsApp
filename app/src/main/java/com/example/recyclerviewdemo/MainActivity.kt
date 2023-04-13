package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val articles = listOf<Article>(
        Article("Variety", "Joe"),
        Article("Life" ,"Frank"),
        Article("Sport","Tom"),
        Article("Life","FJoe"),
        Article("Variety","Alex"),
        Article("Politics","Joe"),
        Article("Life","Alex")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myrecyclerView)
        recyclerView.setBackgroundColor(Color.WHITE)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(articles) { selectedItem: Article ->
            listItemClicked(selectedItem)
        }

    }
    private fun listItemClicked(fruit: Article){
        Toast.makeText(
            this@MainActivity,
            "Supplier is: ${fruit.name}",
            Toast.LENGTH_LONG
        ).show()
    }
}