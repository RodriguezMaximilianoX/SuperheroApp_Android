package com.example.superheroapp.data.network

import android.util.Log
import com.example.superheroapp.data.model.SuperheroModelResponse
import javax.inject.Inject

class SuperheroService @Inject constructor(private val superheroApiService: SuperheroApiService) {

    suspend fun getResponseModel(name: String): List<SuperheroModelResponse> {
        val response = superheroApiService.getSuperheroes(name)
        Log.i("Variable Response", response.toString())
        return if (response.isSuccessful) {
            Log.i("SuperheroService", response.body().toString())
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }

}