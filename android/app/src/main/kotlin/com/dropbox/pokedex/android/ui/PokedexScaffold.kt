package com.dropbox.pokedex.android.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import app.cash.redwood.treehouse.TreehouseView
import com.dropbox.pokedex.android.PokedexApp
import com.dropbox.pokedex.android.navigation.Routing

@Composable
fun PokedexScaffold(
    app: PokedexApp,
    widgets: TreehouseView.WidgetSystem,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { PokedexBottomBar(navController = navController) }
    ) { innerPadding ->
        Routing(
            app = app,
            widgets = widgets,
            navController = navController,
            innerPadding = innerPadding
        )
    }
}