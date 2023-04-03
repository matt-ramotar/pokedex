package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import com.dropbox.pokedex.common.client.HttpClient
import com.dropbox.pokedex.treehouse.foundation.TextStyle
import com.dropbox.pokedex.treehouse.schema.compose.Text
import com.dropbox.pokedex.treehouse.schema.compose.TextInput
import com.dropbox.pokedex.treehouse.state.TextFieldState


enum class PokedexTabComponentType {
    Text,
    Search,
    Tile
}

sealed class PokedexTabComponent {
    data class Text(
        val text: String,
        val style: TextStyle
    ) : PokedexTabComponent()
}

@Composable
fun PokedexTab(
    httpClient: HttpClient,
    columnProvider: ColumnProvider
) {

    val items = listOf(
        PokedexTabComponent.Text,
        PokedexTabComponent.Search,
        Pok
    )

    columnProvider.lazy() {
        Row {

            Text(text = "What Pokémon are you looking for?", style = TextStyle.Name("h4"))
        }
        Search()

    }

}

@Composable
fun Search() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextInput(
        state = TextFieldState(text = text.text)
    )
}