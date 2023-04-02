package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import app.cash.redwood.layout.api.Constraint
import app.cash.redwood.layout.api.CrossAxisAlignment
import app.cash.redwood.layout.api.Margin
import app.cash.redwood.layout.compose.Column
import com.dropbox.pokedex.common.api.RealPokeApi
import com.dropbox.pokedex.common.client.HttpClient
import com.dropbox.pokedex.common.entity.Pokemon
import com.dropbox.pokedex.treehouse.schema.compose.Text

@Composable
fun Pokedex(
    httpClient: HttpClient,
    columnProvider: ColumnProvider
) {

    val model = remember {
        PokemonModel(
            api = RealPokeApi(
                client = httpClient
            )
        )
    }

    LaunchedEffect(Unit) {
        model.load(1)
    }

    val state = model.state.collectAsState()

    when (val pokemon = state.value.pokemon) {
        null -> Loading()
        else -> Pokemon(pokemon)
    }
}


@Composable
private fun Loading() {
    Column(
        width = Constraint.Fill,
        horizontalAlignment = CrossAxisAlignment.Stretch,
        margin = Margin(horizontal = 24)
    ) {
        Text("Initial")
    }
}

@Composable
private fun Pokemon(pokemon: Pokemon) {
    Column(
        width = Constraint.Fill,
        horizontalAlignment = CrossAxisAlignment.Stretch,
        margin = Margin(horizontal = 24)
    ) {
        Text(pokemon.name)
    }
}

