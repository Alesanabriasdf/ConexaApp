package com.example.conexaapp.model.contacts

import com.google.gson.annotations.SerializedName

data class ContactModel(
    @SerializedName("id") val id: String,
    @SerializedName("image") val image: String?,
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: String,
    @SerializedName("localization") val localization: Localization
)
