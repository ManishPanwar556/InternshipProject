package com.example.fitnesstracker.repository

import android.content.Context
import android.util.Log
import com.example.fitnesstracker.retrofit.BitrootClient
import com.example.fitnesstracker.room.BitrootDatabase
import com.example.fitnesstracker.room.BitrootEntity
import java.io.IOException

class BitrootRepository(context: Context) {

    private val db by lazy{
        BitrootDatabase.getInstance(context).bitrootDao
    }
    suspend fun insertData(){
        try {
            val result = BitrootClient.service.getResult()
            if(result.isSuccessful) {
                val data = result.body()?.data
                data?.let {

                    val bitrootEntity = BitrootEntity(1,it.heartRate, it.sleepTime, it.trainingTime)
                    db.insertFitnessData(bitrootEntity)


                }
            }
        }
        catch (exc:IOException){
            Log.e("Exception","$exc")
        }

    }

    suspend fun getData():BitrootEntity{
        return db.getFitnessData()
    }

}