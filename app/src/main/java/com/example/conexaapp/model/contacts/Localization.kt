package com.example.conexaapp.model.contacts

import com.google.gson.annotations.SerializedName

data class Localization(
    @SerializedName("lat") val lat: Double,
    @SerializedName("long") val long: Double
)
