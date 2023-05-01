package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: DataLoaderViewModel
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        viewModel = ViewModelProvider(this)[DataLoaderViewModel::class.java]

        viewModel.isLoading.observe(this, Observer { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        viewModel.loadNews("us", ApiConstants.API_KEY)

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        recyclerView.setBackgroundColor(Color.WHITE)

        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.news.observe(this) {
            recyclerView.adapter = MyRecyclerViewAdapter(newsResponse = it)
        }

    }
}