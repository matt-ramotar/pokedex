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
import com.dropbox.pokedex.treehouse.presenter.componentbox.component.*
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

    SkeletonLoadingContainer {
        ComponentBox(componentBox = forest {
            if (tile1.value != null) {
                tree("tile1", tree(tile1.value!!))
            }

            if (tile2.value != null) {
                tree("tile2", tree(tile2.value!!))
            }

            if (tile3.value != null) {
                tree("tile3", tree(tile3.value!!))
            }

            if (tile4.value != null) {
                tree("tile4", tree(tile4.value!!))
            }
        })
    }
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
private fun pokemonTile(id: Int, delay: Long): StateFlow<Component?> {
    val url = "https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/${id}.svg"

    val color = LocalSkeletonLoadingColor.current

    val isLoading = remember { mutableStateOf(true) }

    val stateFlow = MutableStateFlow<Component?>(null)
    val state = stateFlow

    LaunchedEffect(Unit) {
        delay(delay)
        isLoading.value = false
    }

    stateFlow.value = when (isLoading.value) {
        true -> box(modifier = Modifier(fillMaxSize = true, background = color), children = {})
        false -> column(modifier = Modifier(fillMaxSize = true)) {
            child(text(id.toString()))
            child(text(id.toString()))
            child(text(id.toString()))
        }
    }

    return state
}



