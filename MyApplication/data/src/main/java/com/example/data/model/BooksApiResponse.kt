package com.example.data.model

import com.example.data.database.entity.BookEntity
import com.example.domain.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksApiResponse(
    @SerialName("error") val error: String = "0",
    @SerialName("total") val total: String = "0",
    @SerialName("page") val page: String = "0",
    @SerialName("books") val books: List<BookResponse> = emptyList()
) {
    @Serializable
    data class BookResponse(
        @SerialName("title") val title: String,
        @SerialName("subtitle") val subTitle: String,
        @SerialName("price") val price: String,
        @SerialName("image") val image: String,
        @SerialName("url") val url: String
    ) {
        fun mapToBook(): Book {
            return Book(title, subTitle, price, image)
        }

        fun mapToBookEntity(): BookEntity {
            return BookEntity(title, subTitle, price, image, url)
        }
    }
}
