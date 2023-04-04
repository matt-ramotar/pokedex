package com.dropbox.pokedex.android.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import app.cash.redwood.treehouse.TreehouseContentSource
import app.cash.redwood.treehouse.TreehouseView
import com.dropbox.pokedex.android.PokedexApp
import com.dropbox.pokedex.android.common.pig.PokedexTheme
import com.dropbox.pokedex.android.common.treehouse.PokedexTreehouseContent
import com.dropbox.pokedex.treehouse.zipline.PokedexGraphPresenter

@Composable
fun Upgrade(app: PokedexApp, widgets: TreehouseView.WidgetSystem) {
    Text("Upgrade")
    val treehouseContentSource = TreehouseContentSource(PokedexGraphPresenter::launch)
    PokedexTheme {
        PokedexTreehouseContent<PokedexGraphPresenter>(
            app.graphTreehouseApp,
            widgets,
            contentSource = treehouseContentSource
        )
    }
}