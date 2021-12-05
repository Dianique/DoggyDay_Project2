package com.example.doggyday_project2.petviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doggyday_project2.data.PetDao

class PetViewModelFactory(
    private val petDao: PetDao,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PetViewModel(petDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}