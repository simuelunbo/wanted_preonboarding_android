package com.example.domain.model

import java.io.Serializable

data class News(
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val content: String,
    val publishedAt: String
) : Serializable