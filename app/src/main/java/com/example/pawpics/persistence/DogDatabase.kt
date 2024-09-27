package com.example.pawpics.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pawpics.data.Dog

@Database(entities = [Dog::class], version = 1)
abstract class DogDatabase: RoomDatabase() {

    abstract fun dogDao(): DogDao

    companion object {

        private var INSTANCE: DogDatabase? = null

        fun getDatabase(context: Context): DogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DogDatabase::class.java,
                    "dog_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }


}