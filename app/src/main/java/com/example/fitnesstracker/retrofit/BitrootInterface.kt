package com.example.fitnesstracker.retrofit

import com.example.fitnesstracker.models.BitrootClass
import retrofit2.Response
import retrofit2.http.GET

interface BitrootInterface {
    @GET("60816ce39a9aa933335504a8")
    suspend fun getResult():Response<BitrootClass>
}