package com.example.doggyday_project2.petviewmodel

import androidx.lifecycle.*
import com.example.doggyday_project2.data.PetDao
import com.example.doggyday_project2.petnetwork.Dog
import com.example.doggyday_project2.petnetwork.PetImageApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class PetViewModel(private val petDao: PetDao) : ViewModel() { //Creates a ViewModel class; responsible for saving data in state and acts as an Observable.

    private val _dogImages =
        MutableLiveData<Dog>() //Create a private val that's only changeable and viewable by me OR rather, within the class itself
    val dogImagesEntity: LiveData<Dog> =
        _dogImages //Set the private val above to val dogImages, which holds Live Data (a holder/wrapper for data objects Dogs and provides observable before for the ViewModel).

    init {
        getNewDog() //Init gives priority to code within its body to be executed first when class is instantiated
    }

    fun getNewDog() { //Function that's initiated first handles the Coroutine Launch
        viewModelScope.launch {
            _dogImages.value = PetImageApi.retrofitService.getRandomPet()
            //_dogImages sets a value that's retrieved as getRandomDog from the retrofitservice activities.

        }
    }

    fun retrieveAll(): LiveData<List<Dog>> {
        return petDao.getAllPet().asLiveData()
    }

  //  fun addPet() {
     //   viewModelScope.launch {
       //     petDao.inputPet()
        }
   // }

    class ViewModelFactory(
        private val petDao: PetDao
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PetViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PetViewModel(petDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }





