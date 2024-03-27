package com.example.superheroapp.domain.model

import com.example.superheroapp.data.model.SuperheroModelResponse

data class SuperheroModel(
    val id: String,
    val name: String,
    val image: String
)

fun SuperheroModelResponse.toDomainModel(): SuperheroModel {
    return SuperheroModel(
        id = this.id,
        name = this.name,
        image = this.image.url
    )
}


