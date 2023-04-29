package com.example.recyclerviewdemo

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?,
    @SerializedName("status")
    var articles: List<ArticleResponse>?
)

class ArticleResponse(
    val sourceResponse: SourceResponse,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
    )
class SourceResponse(
    val id: String?,
    val name: String?
)
