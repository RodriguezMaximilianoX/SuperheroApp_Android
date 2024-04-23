package com.example.superheroapp.data.network

import android.util.Log
import com.example.superheroapp.data.model.SuperheroDetailImage
import com.example.superheroapp.data.model.SuperheroDetailResponse
import com.example.superheroapp.data.model.SuperheroModelResponse
import com.example.superheroapp.data.model.SuperheroPowerstats
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

    suspend fun getSuperheroDetail(id: String): SuperheroDetailResponse {
        val response = superheroApiService.getSuperheroID(id)
        Log.i("Response Detail", response.toString())
        return if(response.isSuccessful) {
            Log.i("SuperheroDetailTrue", response.body().toString())
            response.body()!!
        } else {
            SuperheroDetailResponse(
                name = "Unknown",
                powerstats = SuperheroPowerstats(
                    intelligence = "0",
                    strength = "0",
                    speed = "0",
                    durability = "0",
                    power = "0",
                    combat = "0"
                ),
                image = SuperheroDetailImage(
                    url = "default_url"
                )
            )
        }
    }

}