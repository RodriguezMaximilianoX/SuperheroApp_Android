package com.example.superheroapp.domain.model

import com.example.superheroapp.data.model.SuperheroDetailResponse

data class SuperheroDetailModel(
    val name: String,
    val image: String,
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

fun SuperheroDetailResponse.toDomainModel() : SuperheroDetailModel{
    return SuperheroDetailModel(
        name = this.name,
        image = this.image.url,
        intelligence = this.powerstats.intelligence,
        strength = this.powerstats.strength,
        speed = this.powerstats.speed,
        durability = this.powerstats.durability,
        power = this.powerstats.power,
        combat = this.powerstats.combat
    )
}

