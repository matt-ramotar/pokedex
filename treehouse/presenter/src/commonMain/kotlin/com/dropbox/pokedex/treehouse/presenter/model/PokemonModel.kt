package com.dropbox.pokedex.treehouse.presenter.model

import com.dropbox.pokedex.common.api.PokeApi
import com.dropbox.pokedex.common.entity.Pokemon

data class PokemonState(
    val pokemon: Pokemon? = null
)

class PokemonModel(
    private val api: PokeApi
) : ComposableModel<PokemonState, String>(PokemonState()) {

    suspend fun load(id: Int) {
        val pokemon = api.getPokemon(id)
        setState(PokemonState(pokemon))
    }

    override fun on(event: String) = when (event) {
        "dismiss" -> {}
        else -> {
            println(event)
        }
    }

}