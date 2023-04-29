package com.example.recyclerviewdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataLoaderViewModel : ViewModel() {

    private val _newsList = MutableLiveData<NewsResponse>()
    val news: LiveData<NewsResponse> = _newsList

    //private val repo = NewsApiService(RetrofitHelper.getInstance().create(NewsApiService::class.java))

    fun loadNews(country: String, apiKey: String) {
        GlobalScope.launch {
            //progressbar.visibility = true
            try {
                val response = RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchNews(country, apiKey)
                _newsList.value = response
            } catch (e: Exception) {
                Log.e("DataLoaderViewModel", "Error: ${e.message}")
                return@launch
            }
        }
    }
}