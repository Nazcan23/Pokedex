package com.example.pokedex
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.model.PokeResult
import kotlinx.android.synthetic.main.card_view_pokemon.view.*

class PokeListAdapter (): RecyclerView.Adapter<PokemonViewHolder>() {
    var pokemonList:List<PokeResult> = emptyList<PokeResult>()
    fun setData(list: List<PokeResult>){
        pokemonList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from((parent.context))
        return PokemonViewHolder(layoutInflater.inflate(R.layout.card_view_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = pokemonList.size




}

