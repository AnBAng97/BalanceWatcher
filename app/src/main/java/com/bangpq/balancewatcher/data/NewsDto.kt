package com.bangpq.googlenews.presenter.data

import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("status")
    var status: String,
    @SerializedName("totalHits")
    var totalHits: Int,
    @SerializedName("page")
    var page: Int,
    @SerializedName("totalPages")
    var totalPages: Int,
    @SerializedName("page_size")
    var page_size: Int,
    @SerializedName("articles")
    var articles: List<NewsItem>

)

data class NewsItem(
    @SerializedName("title")
    var title: String,
    @SerializedName("author")
    var author: String,
    @SerializedName("publishedData")
    var publishedData: String,
    @SerializedName("link")
    var link: String,
    @SerializedName("exception")
    var exception: String,
    @SerializedName("summary")
    var summary: String,
    @SerializedName("media")
    var media: String,
    @SerializedName("_id")
    var _id: String
)


