package com.example.conexaapp.model.news

import com.google.gson.annotations.SerializedName

data class NewDetailModel (
    @SerializedName("id") val id: String,
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("author") val author: String
)