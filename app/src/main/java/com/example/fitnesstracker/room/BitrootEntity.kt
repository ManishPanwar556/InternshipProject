package com.example.fitnesstracker.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class BitrootEntity(
    @PrimaryKey(autoGenerate = false)
    var id:Int,
    var heartRate:String,
    var sleepTime:String,
    var trainingTime:String
)
