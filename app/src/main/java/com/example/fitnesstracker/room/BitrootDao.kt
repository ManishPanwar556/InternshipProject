package com.example.fitnesstracker.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BitrootDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFitnessData(entity: BitrootEntity)

    @Query("Select* from user_table")
    suspend fun getFitnessData():BitrootEntity
}