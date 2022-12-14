package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("sprites") val sprites: Sprites

)
data class Sprites(
    @Expose @SerializedName("front_default") val front_default: String?,
    @Expose @SerializedName("front_shiny") val front_shiny: String?

)