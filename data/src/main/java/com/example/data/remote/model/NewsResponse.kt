package com.example.data.remote.model

import com.example.domain.model.News
import com.google.gson.annotations.SerializedName

internal data class NewsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<Articles>
)

internal data class Articles(
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content: String?
) {
    fun convertToNews(): News {
        return News(
            title = this.title ?: "title",
            author = if (this.author.isNullOrEmpty()) "Author" else this.author,
            description = this.description ?: "",
            url = this.url ?: "",
            urlToImage = this.urlToImage ?: "",
            content = this.content ?: "",
            publishedAt = this.publishedAt ?: ""
        )
    }
}

