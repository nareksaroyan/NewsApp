package com.example.recyclerviewdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataLoaderViewModel : ViewModel() {

    public val _newsList = MutableLiveData<NewsResponse>()
    val news: LiveData<NewsResponse> = _newsList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadNews(country: String, apiKey: String) {
        GlobalScope.launch {
            _isLoading.postValue(true)
            try {
                val response = RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchNews(country, apiKey)
                if(response.status == ApiConstants.OK_STATUS_RESPONSE)
                    _newsList.value = response
            } catch (e: Exception) {
                Log.e("DataLoaderViewModel", "Errdfor: ${e.message}")
                return@launch
            }finally {
                _isLoading.postValue(false)
            }
        }
    }
}