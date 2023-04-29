package com.example.recyclerviewdemo

import android.os.Build.VERSION
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("/${ApiConstants.VERSION}/top-headlines")
    suspend fun fetchNews(@Query("country") country: String, @Query("apiKey") apiKey: String): NewsResponse
}