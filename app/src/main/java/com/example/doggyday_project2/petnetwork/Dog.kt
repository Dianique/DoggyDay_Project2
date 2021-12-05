package com.example.doggyday_project2.petnetwork

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "pet_table")
data class Dog(
    //Data class 'Dogs' contains the Api response key= message and value type= String in Json Annotation format.

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @Json(name = "message")
    @ColumnInfo(name = "imageLink")
    val message: String?,

    @ColumnInfo(name = "status")
    val status: String,
)
