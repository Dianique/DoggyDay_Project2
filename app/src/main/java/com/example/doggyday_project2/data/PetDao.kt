package com.example.doggyday_project2.data
import androidx.room.*
import com.example.doggyday_project2.petnetwork.Dog
import kotlinx.coroutines.flow.Flow

@Dao //Holds the methods used for accessing the database = DAO
interface PetDao { //access the methods within the class
    //Define methods to retrieve all the rows in database and a method to insert individual dog variables

    @Query("SELECT * FROM pet_table")
    fun getAllPet(): Flow<List<Dog>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inputPet(dog: Dog)



}