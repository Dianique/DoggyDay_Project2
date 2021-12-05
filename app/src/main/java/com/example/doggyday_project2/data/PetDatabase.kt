package com.example.doggyday_project2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.doggyday_project2.petnetwork.Dog

@Database(entities = [Dog::class], version = 1)
abstract class PetDatabase : RoomDatabase() {
    abstract fun petDao(): PetDao

    companion object {
        @Volatile
        private var INSTANCE: PetDatabase? = null

        fun getDatabase(context: Context): PetDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    PetDatabase::class.java,
                    "app_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}

/*
The class must be annotated with a @Database annotation that includes an entities array that lists all of the data entities associated with the database.
The class must be an abstract class that extends RoomDatabase.
For each DAO class that is associated with the database, the database class must define an abstract method that has zero arguments and returns an instance of the DAO class
 */