package com.example.superheroapp.data

import com.example.superheroapp.data.network.SuperheroService
import com.example.superheroapp.domain.model.SuperheroDetailModel
import com.example.superheroapp.domain.model.SuperheroModel
import com.example.superheroapp.domain.model.toDomainDetailModel
import com.example.superheroapp.domain.model.toDomainModel
import javax.inject.Inject

class Repository @Inject constructor(private val service: SuperheroService) {

    suspend fun searchSuperhero(name: String): List<SuperheroModel> {

        val response = service.getResponseModel(name)
        return response.map { it.toDomainModel() }
    }

    suspend fun getSuperheroDetail(superheroId: String): SuperheroDetailModel {
        val response = service.getSuperheroDetail(superheroId)
        return response.toDomainDetailModel()
    }

}