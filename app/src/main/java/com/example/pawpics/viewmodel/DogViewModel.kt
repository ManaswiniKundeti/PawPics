package com.example.pawpics.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pawpics.data.Dog
import com.example.pawpics.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val repository: DogRepository
): ViewModel() {

    private val _dogs = MutableLiveData<List<Dog>>()
    val dogs: LiveData<List<Dog>> = _dogs

    init {
        getDogs()
    }

    private fun getDogs() {
        viewModelScope.launch {
            val dogsFromNetwork = repository.getDogsFromNetwork()
            _dogs.value = dogsFromNetwork
        }
    }
}