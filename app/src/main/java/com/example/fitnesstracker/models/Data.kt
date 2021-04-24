package com.example.fitnesstracker.models


import com.squareup.moshi.Json

data class Data(
    @Json(name = "heart-rate")
    val heartRate: String,
    @Json(name = "sleep-time")
    val sleepTime: String,
    @Json(name = "training-time")
    val trainingTime: String
)