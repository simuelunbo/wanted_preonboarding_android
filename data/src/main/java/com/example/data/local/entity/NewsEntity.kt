package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.News

@Entity
internal data class NewsEntity(
    @PrimaryKey
    var title : String,
    var author: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
) {
    fun convertToNews(): News {
        return News(
            title = this.title,
            author = this.author,
            description = this.author,
            url = this.author,
            urlToImage = this.urlToImage,
            publishedAt = this.publishedAt,
            content = this.content
        )
    }
}
