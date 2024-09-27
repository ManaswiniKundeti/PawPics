package com.example.pawpics.repository

import com.example.pawpics.data.Dog
import com.example.pawpics.network.RetrofitInstance
import com.example.pawpics.persistence.DogDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DogRepository(private val dogDao: DogDao) {

    val allDogs: Flow<List<Dog>> = dogDao.getAllDogs()

    suspend fun refreshDogs() {
        withContext(Dispatchers.IO) {
            val dogs = RetrofitInstance.apiService.getBreeds()
            dogDao.insertAll(dogs)
        }
    }
}