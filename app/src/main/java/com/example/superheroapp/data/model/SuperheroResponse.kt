package com.example.superheroapp.data.model

import com.google.gson.annotations.SerializedName

data class SuperheroResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperheroModelResponse>
)

data class SuperheroModelResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperheroImage
)

data class SuperheroImage(
    @SerializedName("url") val url: String
)

