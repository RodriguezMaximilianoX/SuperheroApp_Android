package com.example.superheroapp.data.model

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name") val name:String,
    @SerializedName("powerstats") val powerstats: SuperheroPowerstats,
    @SerializedName("image") val image: SuperheroDetailImage
)

data class SuperheroDetailImage (
    @SerializedName("url") val url: String
)

data class SuperheroPowerstats (
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)
