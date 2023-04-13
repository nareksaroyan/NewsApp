package com.example.recyclerviewdemo

data class News(
    val articles: List<ArticleX>,
    val status: String,
    val totalResults: Int
)