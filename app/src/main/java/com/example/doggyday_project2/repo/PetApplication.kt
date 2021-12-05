package com.example.doggyday_project2.repo

import android.app.Application
import com.example.doggyday_project2.data.PetDatabase


class PetApplication : Application(){ //Instantiate the database instance in the application class.
    val database: PetDatabase by lazy { PetDatabase.getDatabase(this) }

    //Instantiate the database instance by calling getDatabase() on ItemRoomDatabase passing in the context.
// Use lazy delegate so the instance database is lazily created when you first need/access the reference (rather than when the app starts).
// This will create the database (the physical database on the disk) on the first access.
}