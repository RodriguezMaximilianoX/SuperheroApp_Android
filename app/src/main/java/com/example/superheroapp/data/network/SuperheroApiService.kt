package com.example.superheroapp.data.network

import com.example.superheroapp.data.model.SuperheroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApiService {

    @GET("api/6765985780157817/search/{name}")
    suspend fun getSuperheroes(@Path("name") name: String): Response<SuperheroResponse>

}