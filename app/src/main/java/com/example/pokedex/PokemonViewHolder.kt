package com.example.pokedex

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.model.PokeResult
import com.example.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.card_view_pokemon.view.*

class PokemonViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val pokemon = view.findViewById<TextView>(R.id.nombrePokemon)
    val img = view.findViewById<ImageView>(R.id.imagenPokemon)
    fun render(pokemonModel: PokeResult){
        pokemon.text = pokemonModel.name
        Glide.with(img.context).load(pokemonModel.sprites).into(img)

    }
}