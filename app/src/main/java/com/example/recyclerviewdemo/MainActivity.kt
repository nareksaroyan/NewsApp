package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: DataLoaderViewModel
    private lateinit var progressBar: ProgressBar
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DataLoaderViewModel::class.java]

        viewModel.isLoading.observe(this, Observer { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        viewModel.loadNews("us", ApiConstants.API_KEY)

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        recyclerView.setBackgroundColor(Color.WHITE)

        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.news.observe(this) {
            recyclerView.adapter = MyRecyclerViewAdapter(newsResponse = it)
        }

        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.searchNews("us", ApiConstants.API_KEY, query)
                } else {
                    viewModel.loadNews("us", ApiConstants.API_KEY)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        binding.searchview.setOnCloseListener {
            viewModel.loadNews("us", ApiConstants.API_KEY)
            false
        }
    }
    private fun fragmentChange(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        //fragmentTransition.replace(R.id.fragmentContainerView, fragment)

    }
}