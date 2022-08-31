package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.PokeListAdapter
import com.example.pokedex.PokemonViewHolder
import com.example.pokedex.PokemonViewModel
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.model.PokeResult
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view_pokemon.*

class Pokemon : AppCompatActivity() {
    //Declarar el binding
    private lateinit var binding: ActivityMainBinding

    //Declarar el modelo al que pertenece
    private lateinit var viewModel: PokemonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inicializar el view model
        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokeListAdapter()
        viewModel.getPokemonLista()

        viewModel.pokemonList.observe(this, Observer { list ->

            (recyclerView.adapter as PokeListAdapter).setData(list)
        })
    }
}