package com.example.pawpics.repository

import com.example.pawpics.data.Dog
import com.example.pawpics.network.DogsApiService
import com.example.pawpics.persistence.DogDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogsApiService: DogsApiService,
    private val dogDao: DogDao
) {

    val allDogs: Flow<List<Dog>> = dogDao.getAllDogs()

    suspend fun getDogsFromNetwork(): List<Dog> {
        return  withContext(Dispatchers.IO) {
            dogsApiService.getBreeds()
        }
    }

    suspend fun refreshDogs() {
        withContext(Dispatchers.IO) {
            val dogsFromNetwork = dogsApiService.getBreeds()
            dogDao.insertAll(dogsFromNetwork)
        }
    }
}