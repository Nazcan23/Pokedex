package com.example.pokedex

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.model.PokeResult
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.RespuestaApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Math.incrementExact
import java.lang.Math.random

class PokemonViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private  val servicio : ServicioApi = retrofit.create(ServicioApi::class.java)
    val pokemonList = MutableLiveData<List<PokeResult>>()
    fun getPokemonLista(){
        var offset = (0..50).random()
        var limite = (0..3).random()
        val call = servicio.getPokemonList(limite,offset)

        call.enqueue(object : Callback<RespuestaApi>{
            override fun onResponse(call: Call<RespuestaApi>, response: Response<RespuestaApi>) {
                response.body()?.results?.let{
                pokemonList.postValue(it)
                }
            }

            override fun onFailure(call: Call<RespuestaApi>, t: Throwable) {
                call.cancel()

            }

        })
    }
}