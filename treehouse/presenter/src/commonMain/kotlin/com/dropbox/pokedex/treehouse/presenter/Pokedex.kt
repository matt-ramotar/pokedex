package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import app.cash.redwood.layout.api.Constraint
import app.cash.redwood.layout.api.CrossAxisAlignment
import app.cash.redwood.layout.api.Margin
import app.cash.redwood.layout.compose.Column
import com.dropbox.pokedex.common.client.HttpClient
import com.dropbox.pokedex.treehouse.componentbox.Component
import com.dropbox.pokedex.treehouse.componentbox.Modifier
import com.dropbox.pokedex.treehouse.presenter.componentbox.component.child
import com.dropbox.pokedex.treehouse.presenter.componentbox.component.column
import com.dropbox.pokedex.treehouse.presenter.componentbox.component.containedButton
import com.dropbox.pokedex.treehouse.presenter.componentbox.component.skeletonLoadingContainer
import com.dropbox.pokedex.treehouse.presenter.componentbox.component.text
import com.dropbox.pokedex.treehouse.presenter.componentbox.forest
import com.dropbox.pokedex.treehouse.presenter.componentbox.tree
import com.dropbox.pokedex.treehouse.schema.compose.ComponentBox
import com.dropbox.pokedex.treehouse.schema.compose.Text
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@Composable
fun Pokedex(
    httpClient: HttpClient,
    columnProvider: ColumnProvider
) {

    val tile1 = pokemonTile(1, 1200)
    val tile2 = pokemonTile(2, 1600)
    val tile3 = pokemonTile(3, 800)
    val tile4 = pokemonTile(4, 2000)

    ComponentBox(componentBox = forest {
        tree("tile1", tree(tile1.value))
        tree("tile2", tree(tile2.value))
        tree("tile3", tree(tile3.value))
        tree("tile4", tree(tile4.value))
    })
}

@Composable
private fun PokemonButton(): Component {
    return containedButton {
        child(text("Learn more"))
    }
}

@Composable
private fun PokemonHeading(): Component {
    return text("Pokemon")
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
private fun pokemonTile(id: Int, delay: Long): StateFlow<Component> {
    val url = "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/${id}.svg"

    val isLoading = remember { mutableStateOf(true) }

    val state = MutableStateFlow<Component>(skeletonLoadingContainer())

    LaunchedEffect(Unit) {
        delay(delay)
        isLoading.value = false
    }

    state.value = when (isLoading.value) {
        true -> skeletonLoadingContainer()
        false -> column(modifier = Modifier(fillMaxSize = true)) {
            child(text(id.toString()))
            child(text(id.toString()))
            child(text(id.toString()))
        }
    }

    return state
}



