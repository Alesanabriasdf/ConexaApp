package com.example.conexaapp.model.news

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("id") val id: String,
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String
)
