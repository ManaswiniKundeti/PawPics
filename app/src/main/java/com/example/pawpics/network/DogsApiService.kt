package com.example.pawpics.network

import com.example.pawpics.data.Dog
import retrofit2.http.GET
import retrofit2.http.Header

interface DogsApiService {

    @GET("v1/breeds")
    suspend fun getBreeds(
        @Header("x-api-key") apiKey: String = "live_7FdzFh7AV3H27WQ6Pqd04qLP0BgWSV3r2oO6iMLFVCn5hPMNu30jTsYSo1kaQVRJ"
    ): List<Dog>
}