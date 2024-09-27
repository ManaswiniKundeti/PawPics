package com.example.pawpics.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pawpics.data.Dog
import com.example.pawpics.persistence.DogDatabase
import com.example.pawpics.repository.DogRepository
import kotlinx.coroutines.launch

class DogViewModel(application: Application): AndroidViewModel(application) {

    private val repository: DogRepository
    val allDogs: LiveData<List<Dog>>

    init {
        val dogDao = DogDatabase.getDatabase(application).dogDao()
        repository = DogRepository(dogDao)
        allDogs = repository.allDogs.asLiveData()
        refreshDogs()
    }

    private fun refreshDogs() {
        viewModelScope.launch {
            repository.refreshDogs()
        }
    }
}