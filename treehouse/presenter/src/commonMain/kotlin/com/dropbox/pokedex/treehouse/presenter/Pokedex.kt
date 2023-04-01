package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.runtime.Composable
import app.cash.redwood.layout.api.Constraint
import app.cash.redwood.layout.api.CrossAxisAlignment
import app.cash.redwood.layout.api.Margin
import app.cash.redwood.layout.compose.Column
import com.dropbox.pokedex.treehouse.schema.compose.Text

@Composable
fun Pokedex(
    httpClient: HttpClient,
    columnProvider: ColumnProvider
) {
    Column(
        width = Constraint.Fill,
        horizontalAlignment = CrossAxisAlignment.Stretch,
        margin = Margin(horizontal = 24)
    ) {
        Text("Bulbasaur")
    }
}