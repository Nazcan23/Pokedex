package com.example.pokedex

import androidx.viewpager2.widget.ViewPager2
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.RespuestaApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServicioApi {
    @GET("pokemon/{id}/")
    fun getPokemonInfo(@Path("id")id: Int): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int,@Query("offset") offset: Int): Call<RespuestaApi>

}