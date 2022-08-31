package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RespuestaApi(
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<PokeResult>

)
data class PokeResult(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("sprites") val sprites: Sprites,
    @Expose @SerializedName("front_default") val front_default: String?
)