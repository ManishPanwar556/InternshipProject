package com.example.fitnesstracker.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BitrootEntity::class],version=1,exportSchema = false)
abstract class BitrootDatabase:RoomDatabase() {
    abstract val bitrootDao: BitrootDao

    companion object {
        @Volatile
        private var INSTANCE: BitrootDatabase? = null
        fun getInstance(context: Context): BitrootDatabase {

            synchronized(BitrootDatabase::class) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BitrootDatabase::class.java,
                        "bitroot_db"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    INSTANCE = instance
                }

                return instance
            }

        }
    }
}