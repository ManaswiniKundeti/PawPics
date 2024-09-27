package com.example.pawpics.repository

import com.example.pawpics.data.Dog
import com.example.pawpics.network.DogsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogsApiService: DogsApiService
) {

//    val allDogs: Flow<List<Dog>> = dogDao.getAllDogs()
//
//    suspend fun refreshDogs() {
//        withContext(Dispatchers.IO) {
//            val dogs = RetrofitInstance.apiService.getBreeds()
//            dogDao.insertAll(dogs)
//        }
//    }

    suspend fun getDogsFromNetwork(): List<Dog> {
        return  withContext(Dispatchers.IO) {
            dogsApiService.getBreeds()
        }
    }
}