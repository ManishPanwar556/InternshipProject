package com.example.fitnesstracker.models


import com.squareup.moshi.Json

data class BitrootClass(
    @Json(name = "code")
    val code: Int,
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "success")
    val success: String
)