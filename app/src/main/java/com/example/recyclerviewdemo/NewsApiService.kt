package com.example.recyclerviewdemo

import android.os.Build.VERSION
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("/${ApiConstants.VERSION}/top-headlines")
    suspend fun fetchNews(@Query("country") country: String,
                          @Query("apiKey") apiKey: String): NewsResponse
    @GET("/${ApiConstants.VERSION}/top-headlines")
    suspend fun searchNews(@Query("country") country: String,
                          @Query("apiKey") apiKey: String,
                          @Query("q") searchTerm:String): NewsResponse
    @GET("/${ApiConstants.VERSION}/top-headlines")
    suspend fun filterNews(@Query("country") country: String,
                          @Query("apiKey") apiKey: String,
                          @Query("category") catergory:String): NewsResponse
}